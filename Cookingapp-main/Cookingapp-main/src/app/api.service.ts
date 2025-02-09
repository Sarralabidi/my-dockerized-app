import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  private BASEURL = "http://172.18.0.3:8082/api/items"
  private baseUrl = "http://172.18.0.3:8082/"
  private apiUrl = 'https://api.spoonacular.com/recipes/findByIngredients';
  private apiKey = 'c131bd6b58a247c2b5505218f885c24e'; // Replace with your API key
  constructor(private http: HttpClient) { }


  getAllItems(): Observable<any> {
    return this.http.get<any>(`${this.BASEURL}`);//we use $ car angular works with typescript
  }
  getRecipesByIngredients(itemIds: number[]): Observable<any[]> {
    return this.http.post<any[]>(`${this.baseUrl}/recipes/findByIngredients`, itemIds);
  }
  searchRecipes(ingredients: string): Observable<any> {
    const url = `${this.apiUrl}?ingredients=${ingredients}&number=5&apiKey=${this.apiKey}`;
    return this.http.get<any>(url);
  }
}
