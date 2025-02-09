import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ImageServiceService {
  private apiKey = 'TbJgHivwEa2VU0Oq-5NXjIueqLUXF2dYCfy7pluDXjU';  // Replace with your Unsplash APIpublic key
  private baseUrl = 'https://api.unsplash.com/search/photos';

  constructor(private http: HttpClient) {}

  searchImages(query: string) {
    return this.http.get(`${this.baseUrl}?query=${query}&client_id=${this.apiKey}`);
  }
}

