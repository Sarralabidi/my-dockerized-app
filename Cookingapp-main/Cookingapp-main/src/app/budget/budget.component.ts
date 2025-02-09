import { Component } from '@angular/core';
import { ApiService } from '../api.service';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ImageServiceService } from '../image-service.service';
import { SharedService } from '../shared.service';

@Component({
  selector: 'app-budget',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './budget.component.html',
  styleUrls: ['./budget.component.css']
})
export class BudgetComponent {
  items: any[] = [];
  budget: number = 0;
  shoppingList: any[] = [];
  recipes: any[] = [];
  selectedItems: Set<string> = new Set(); // To store selected item IDs
   itemstab: string[] = Array.from(this.selectedItems);
 itemsString: string = this.itemstab.join(', ');

  imageUrls: { [key: string]: string } = {};
  totalCost: number = 0;
  reciepeData: any = {};

 
  constructor(private apiService: ApiService, private imageService: ImageServiceService, private router: Router,private sharedService: SharedService) {}

  ngOnInit() {
    this.loadItems();
    this.loadRecipes();

  
  }

  search(): void {
    if (this.itemsString.trim() === '') {
      alert('Please select at least one item to generate recipes.');
      return;
    }
  
    this.apiService.searchRecipes(this.itemsString).subscribe(data => {
      this.recipes = data;
      this.reciepeData=data;
      this.sharedService.setFormData(this.reciepeData);

      console.log('Recipes:', data);
      console.log('Recipes 2 :', this.reciepeData);

    }, error => {
      console.error('Error fetching recipes', error);
    });
  }
  

  loadRecipes() {
    this.apiService.getRecipesByIngredients(this.shoppingList).subscribe(
      (data: any[]) => {
        this.recipes = data;
      },
      (error: any) => {
        console.error('Error fetching recipes', error);
      }
    );  
  }

//astuce here : hatina wakt delai bch tousel data kbal ken y accedi feha w heya wesletch
  generateReciepeList(){
    this.search();  // This should set the data in SharedService
    setTimeout(() => {
      this.router.navigate(['/reciepe']);  // Navigate to ReceipeComponent
    }, 1000);  // Add a slight delay to ensure data is set before navigating
  }
  



  onItemChecked(event: any, itemId: string) {
    if (event.target.checked) {
      this.selectedItems.add(itemId); // Add the ID to the set
    } else {
      this.selectedItems.delete(itemId); // Remove the ID from the set
    }
 // Update itemsString after each change in selectedItems
 this.itemsString = Array.from(this.selectedItems).join(', ');

 console.log('Selected Items:', Array.from(this.selectedItems));
 console.log('Items String:', this.itemsString)  }

  loadItems() {
    this.apiService.getAllItems().subscribe(
      (data: any) => {
        this.items = data;
        console.log(this.items);
        this.fetchImages();
      },
      (error: any) => {
        console.error('Error fetching items', error);
      }
    );
  }

  fetchImages() {
    this.items.forEach(item => {
      this.imageService.searchImages(item.name).subscribe(
        (response: any) => {
          if (response.results.length > 0) {
            this.imageUrls[item.name] = response.results[0].urls.small;
          }
        },
        (error: any) => {
          console.error('Error fetching images', error);
        }
      );
    });
  }

  generateShoppingList() {
    if (this.budget <= 0) {
      alert('Please enter a valid budget.');
      return;
    }

    this.shoppingList = this.knapsackAlgorithm(this.items, this.budget);
    this.totalCost = this.calculateTotalCost(this.shoppingList);
  }

  knapsackAlgorithm(items: any[], maxBudget: number): any[] {
    // Assign a random weight to each item so with each submit new results appear
    const weightedItems = items.map(item => ({
        ...item,
        weight: Math.random()
    }));

    // Sort items by their random weights
    weightedItems.sort((a, b) => a.weight - b.weight);

    let totalPrice = 0;
    const result: any[] = [];

    for (const item of weightedItems) {
      if (totalPrice + item.price <= maxBudget) {
        result.push(item);
        totalPrice += item.price;
      }
    }

    return result;
}


  shuffleArray(array: any[]): any[] {
    for (let i = array.length - 1; i > 0; i--) {
      const j = Math.floor(Math.random() * (i + 1));
      [array[i], array[j]] = [array[j], array[i]];
    }
    return array;
  }

  calculateTotalCost(shoppingList: any[]): number {
    return shoppingList.reduce((sum, item) => sum + item.price, 0);
  }
}
