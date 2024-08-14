## 1/ Introduction
The purpose of InventUrStock is to allow registered users, specifically a business or organization, to keep and manage inventory of any department or items you need to keep track of. InventUrStock provides a user-friendly experience with the use of visuals and animations to replicate our modern-day applications. The design of the app is very simplistic and easy to follow. Our inventory management system is protected, especially being a web database, the access to the inventory is locked from the public’s eyes. Access to the database is through a registered account. Account verification is through email. The only users that will be able to access, register and login to InventUrStock would be under the companies that have requested in use of the app or companies that the app has been supplied to.
<br/><br/>


## 2/ List of controls used and their purposes
<details><summary>Click to open</summary><br/>
  
### &emsp; 2.1/ External controls and uses implemented into Android Studio
<details><summary>Click to open</summary>

<br/><br/>
_____________________________________________________________________________________________________________________
> recyclerView<br/>

Used to display the inventory, allows user to interact and items in
inventory. 
+ Used in (`ViewItemsEdit.java`)

<br/><br/>
_____________________________________________________________________________________________________________________
> Liquid Pager / Liquid Swipe<br/>

Used to display three (3) fragment activity that explains a few features about InventUrStock. 
+ Used in (`activity_main.xml`)

<br/><br/>
_____________________________________________________________________________________________________________________
> Kotlin to Java converter<br/>

Used with Liquid Pager to convert the functions from Kotlin to Java.

<br/><br/>
_____________________________________________________________________________________________________________________
> Floating Action Button<br/>

Used to have a small and stylish clickable button that will redirect you to the ViewItemsEdit activity to access edit mode for the inventory data.
+ Used in (`ViewItems`)
  
Used to redirect to the AddItems activity to add more inventory.
+ Used in (`ViewItemsEdit`)

<br/><br/>
_____________________________________________________________________________________________________________________
> Gif image<br/>

Used to give a stylish, modern, and movable splash activity.
+ Used in (`activity_main.xml`)

<br/><br/>
_____________________________________________________________________________________________________________________
> Firebase<br/>

Google's Firebase framework allows developers to create mobile and web apps.

<br/><br/>
_____________________________________________________________________________________________________________________
> Firebase Realtime Database<br/>

Used to have a location to store all user accounts and their details, as well as any inventory the users requested to keep stock of through the AddItems activity.

<br/><br/>
_____________________________________________________________________________________________________________________
> Firebase Authentication<br/>

Used to assist the user login, registration, and password change activities with their custom functions.
+ Used in (`RegisterPage.java`) (`LoginActivity.java`) (`ChangePassword.java`) (`ForgotPassword.java`)
</details><br/>

### &emsp; 2.2/ Internal controls and uses in Android Studio
<details><summary>Click to open</summary>

<br/><br/>
_____________________________________________________________________________________________________________________
> ProgressBar<br/>

Used to show duration of task initiated. 
+ Used in (`activity_login.xml`) (`activity_register_page.xml`) (`activity_change_password.xml`) (`activity_forgot_password.xml`)

<br/><br/>
_____________________________________________________________________________________________________________________
> ImageView<br/>

Used for fragment activity page indicator.
+ Used in (`fragment_on_boarding1.xml`) (`fragment_on_boarding2.xml`) (`fragment_on_boarding3.xml`)

<br/><br/>
_____________________________________________________________________________________________________________________
> TextView<br/>

Majority were used as animated backgrounds, either white or dark gray.
+ Used in (`All Activity xml’s`)
  
Used as titles in activities such as “InventUrStock” or “Registration”. 
+ Used in (`All Activity xml’s`)
  
Used to display information about InventUrStock. 
+ Used in (`fragment_on_boarding1.xml`) (`fragment_on_boarding2.xml`) (`fragment_on_boarding3.xml`)
  
Used for a user greeting when in the inventory menu. 
+ Used in (`activity_inventory_page.xml`)
</details>

</details><br/><br/>


## 3/ Database Photos

<details><summary>Click to open</summary><br/>

### &emsp; 3.1/ OPENED AND CLOSED NODES IN DATABASE
<details><summary>Click to open</summary>

_____________________________________________________________________________________________________________________
  
> ![image](https://github.com/user-attachments/assets/9b59d162-ce28-4175-9093-988e1167f81e)

_____________________________________________________________________________________________________________________

</details>
  
### &emsp; 3.2/ ADDED ACCOUNT AND INVENTORY DATA
<details><summary>Click to open</summary>

_____________________________________________________________________________________________________________________

> ![image](https://github.com/user-attachments/assets/72208499-e007-4e29-b1ea-0cb8f1cd72b6)

<br/><br/>

> ![image](https://github.com/user-attachments/assets/49baf31c-9a7d-448b-9689-e89794c9cf02)

_____________________________________________________________________________________________________________________

</details>

### &emsp; 3.3/ ACCOUNT AND INVENTORY DELETION
<details><summary>Click to open</summary>
  
![image](https://github.com/user-attachments/assets/1d1fc6fd-27bc-4122-80aa-4624f3d3e91a)<br/><br/>
![image](https://github.com/user-attachments/assets/c32765ce-d6b9-4601-87d2-8ed10f980653)

</details>

### &emsp; 3.4/ INVENTORY OVERRITE
<details><summary>Click to open</summary>
  
![image](https://github.com/user-attachments/assets/bf3de3a4-4e79-4da0-9043-d8dbba20b21e)

</details>

</details><br/><br/>


## 4/ Output screenshots of application running
<details><summary>Click to open</summary>
  
### &emsp; 4.1/ Splash screen start
<details><summary>Click to open</summary>

![image](https://github.com/user-attachments/assets/bf99be7c-0a43-4dca-b806-3d090723cb7b)
  
</details>
  
### &emsp; 4.2/ Fragment liquid slider
<details><summary>Click to open</summary>

What it looks like in the app
![image](https://github.com/user-attachments/assets/f6d369cb-eb4b-423c-87ee-ab3013dc2490)

`fragment_on_boarding1.xml`
![image](https://github.com/user-attachments/assets/91f4703b-a45a-41e4-aee5-685f3f348f70)

`fragment_on_boarding2.xml`
![image](https://github.com/user-attachments/assets/40c88b2b-2b66-448e-a3ad-5110660f6ad0)

`fragment_on_boarding3.xml`
![image](https://github.com/user-attachments/assets/e2958a4b-a547-4a19-92b1-e485b4c5fcd5)

</details>

### &emsp; 4.3/ Account registration
<details><summary>Click to open</summary>

![image](https://github.com/user-attachments/assets/658e7b89-809b-4db3-9364-9c60fabea24b)

![image](https://github.com/user-attachments/assets/eedf34d3-242a-4c24-8a9e-9ed6f1738a53)

</details>

### &emsp; 4.4/ Email verification
<details><summary>Click to open</summary>

![image](https://github.com/user-attachments/assets/e2094d86-48c3-45f1-80b0-ceb567f610ee)

_____________________________________________________________________________________________________________________

### &emsp; &emsp; 4.4.1/ Email sent
<details><summary>Click to open</summary>

![image](https://github.com/user-attachments/assets/85df95fc-196a-44e8-8d87-55b8dccabf8a)

</details>

### &emsp; &emsp; 4.4.2/ After clicking on link
<details><summary>Click to open</summary>

![image](https://github.com/user-attachments/assets/808dfcd1-ba8d-47df-8d67-1ee5120beb02)

</details>

</details>

### &emsp; 4.7/ Inventory menu
<details><summary>Click to open</summary>


</details>

### &emsp; 4.8/ Viewing the profile
<details><summary>Click to open</summary>


</details>

### &emsp; 4.9/ Returned to the menu, add new items
<details><summary>Click to open</summary>


</details>

### &emsp; 4.10/ Viewing all items
<details><summary>Click to open</summary>


</details>

### &emsp; 4.11/ Deleting new addition, accessed by clicking edit button at the bottom right
<details><summary>Click to open</summary>


</details>

### &emsp; 4.12/ Exit edit mode button returns to previous activity displaying a non-interactable List View
<details><summary>Click to open</summary>


</details>

### &emsp; 4.13/ Adding new data, accessed by clicking plus button at the bottom right in edit activity
<details><summary>Click to open</summary>


</details>

### &emsp; 4.14/ Change / Forgot Password 
<details><summary>Click to open</summary>
(Both activities are practically the same. Only difference is when clicking the return to menu button, one returns you to your account display (Change Password since you are already in the account), and the other returns you to login (Forgot Password since you are not in the account). I could have set it to one activity controlling the password reset, though in the case of the user logged in accidently clicking it, they would not want to be logged out just trying to return to their account display)


</details>
 
### &emsp; 4.15/ Email sent
<details><summary>Click to open</summary>


</details>

### &emsp; 4.16/ After clicking link
<details><summary>Click to open</summary>


</details>

### &emsp; 4.17/ Old pass no longer works
<details><summary>Click to open</summary>


</details>

### &emsp; 4.18/ New pass
<details><summary>Click to open</summary>


</details>

### &emsp; 4.19/ Account deleting
<details><summary>Click to open</summary>


</details>

### &emsp; 4.20/ Data can be displayed showing which user in the company entered it
<details><summary>Click to open</summary>


</details>

</details>
