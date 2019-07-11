package com.example.mvvmsample.viewmodel

import android.os.Parcel
import android.os.Parcelable
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.mvvmsample.model.User
import android.util.Patterns
import android.text.TextUtils
import androidx.databinding.library.baseAdapters.BR


class LoginViewModel : BaseObservable(){

    private lateinit var user : User;
    init {
        user = User("","")
    }
    private val successMessage = "Login was successful"
    private val errorMessage = "Email or Password not valid"

    @Bindable
    private var toastMessage:String = ""

    fun getToastMessage():String{
        return toastMessage;
    }

    fun setToasMessage(message:String){
        this.toastMessage = message
        notifyPropertyChanged(BR.toastMessage)
    }

    @Bindable
    fun getUserEmail():String{
        return user.email!!
    }

    @Bindable
    fun getUserPassword():String{
        return user.password!!
    }

    fun setUserEmail(email:String){
        user.email = email
        notifyPropertyChanged(BR.userEmail)
    }

    fun setUserPassword(password:String){
        user.password = password
        notifyPropertyChanged(BR.userPassword);
    }

    fun onLoginClicked(){

        if(isInputDataValid()){
            setToasMessage(successMessage)
        }else{
            setToasMessage(errorMessage)
        }

    }

    fun isInputDataValid(): Boolean {
        return !TextUtils.isEmpty(getUserEmail()) && Patterns.EMAIL_ADDRESS.matcher(getUserEmail()).matches() && getUserPassword().length > 5
    }

}