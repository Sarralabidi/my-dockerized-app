import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root' // so it holds the data across different components.
})
export class SharedService {
  private formData: any = {};

  setFormData(data: any) {
    this.formData = data;
  }

  getFormData() {
    return this.formData;
  }
}

