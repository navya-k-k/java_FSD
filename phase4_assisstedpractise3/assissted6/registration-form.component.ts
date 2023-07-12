import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
@Component({
  selector: 'app-registration-form',
  templateUrl: './registration-form.component.html',
  styleUrls: ['./registration-form.component.css']
})
export class RegistrationFormComponent {
  formData = {
    name: '',
    email: '',
    password: ''
  };

  submitForm(form: NgForm) {
    if (form.valid) {
      // Form is valid, perform form submission logic
      console.log('Form submitted:', this.formData);
      // Additional logic...
    } else {
      // Form is invalid, handle form validation errors
      console.log('Form is invalid');
    }
  }
}
