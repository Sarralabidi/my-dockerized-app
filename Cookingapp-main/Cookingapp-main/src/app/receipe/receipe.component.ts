import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { SharedService } from '../shared.service';

@Component({
  selector: 'app-receipe',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './receipe.component.html',
  styleUrls: ['./receipe.component.css']
})
export class ReceipeComponent implements OnInit {
  recipes: any[] = []; // Should be an array

  constructor(private sharedService: SharedService) {}

  ngOnInit() {
    this.recipes = this.sharedService.getFormData(); // Get the array of recipes from the service
    console.log(this.recipes); // Check if the data is correctly received
  }
}
