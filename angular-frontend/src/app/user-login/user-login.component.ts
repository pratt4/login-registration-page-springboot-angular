import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../user';
import { LoginuserService } from '../loginuser.service';

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css'],
})
export class UserLoginComponent {
  user: User = new User();

  constructor(
    private loginuserservice: LoginuserService,
    private router: Router
  ) {}

  ngOnInit(): void {}

  userLogin() {
    console.log(this.user);
    this.loginuserservice.loginUser(this.user).subscribe(
      (data) => {
        alert('login successful');
        this.router.navigate(['/home']);
      },
      (error) => alert('invalid credentials')
    );
  }
}
