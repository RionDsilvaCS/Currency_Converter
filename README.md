# Currency Converter in Android Studio
##### What is a Currency Converter?
- A currency converter is a software application or website that provides for the easy conversion of currency values based on present-day exchange rates.
- Such currency converters can easily be found for free on the Internet, and can quickly convert the value of one currency to another, such as dollars to euros, or euros to pounds, and back again.

Our Currency Converter is to convert Rupees to Dollar, Euro and Yen.

Lets begin with developing a currency converter in [==Android Studio==](https://www.googleadservices.com/pagead/aclk?sa=L&ai=DChcSEwjEjZz55KT9AhXOfysKHeIsDuwYABAAGgJzZg&ohost=www.google.com&cid=CAESauD2SDqKRfYj8zz1kDbaYQ1KRI2A2GFsabZrrgsdCVPhQ0L2WlCW3sI-rZqLmyIAmE4EvMvbhSbugDmLx6HTIseCXxsZ9-JmMKdq4if1wzXKazKxjrkoNuKgvHCYTxj2-wCXlw9ef0rDax4&sig=AOD64_2vLV-rvnW7BbQ3miGH88wuAy-Q9g&q&adurl&ved=2ahUKEwiT5Jb55KT9AhVgcGwGHaI_A8oQ0Qx6BAgJEAE) using ==Java== 

While creating the project in Android Studio select as ==Empty Activity== and we are good to go.

*Note: if you are unfamilier with syntax used in the project, than [Discription](#Discription) is given at the end of this conversation*


### Contents
---
- [Currency Converter](https://github.com/RionDsilvaCS/Currency_Converter/new/master?readme=1#what-is-a-currency-converter)
- [XML Code](https://github.com/RionDsilvaCS/Currency_Converter/new/master?readme=1#xml-code)
- [Java Code](https://github.com/RionDsilvaCS/Currency_Converter/new/master?readme=1#java-code)
- [Output](https://github.com/RionDsilvaCS/Currency_Converter/new/master?readme=1#output-screen)
- [Discription](#Discription)


## XML Code
---
>activity_main.xml 

Lets begin with building the interface first and than working on the logic.

The default ==xml== code provided by android studio
```xml
<?xml version="1.0" encoding="utf-8"?>  
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"  
    xmlns:app="http://schemas.android.com/apk/res-auto"  
    xmlns:tools="http://schemas.android.com/tools"  
    android:layout_width="match_parent"  
    android:layout_height="match_parent"  
    tools:context=".MainActivity">
    
</androidx.constraintlayout.widget.ConstraintLayout>
```

Now lets add a ==TextView== to the interface, with text "Currency Converter", this should be present inside the constraintlayout.
```xml
<TextView  
    android:id="@+id/textView"  
    android:layout_width="wrap_content"  
    android:layout_height="wrap_content"  
    android:layout_marginTop="52dp"  
    android:text="Currency Convertor"  
    android:textSize="25sp"  
    />
```

Next we will be adding a ==EditText== box to take the input from the user, and place it below the Currency Converter text.
```xml
<EditText  
    android:id="@+id/inputb"  
    android:layout_width="242dp"  
    android:layout_height="43dp"  
    android:layout_marginTop="64dp"  
    android:layout_marginEnd="84dp"  
    android:ems="10"  
    android:hint="Enter the Amount in Rs"  
    android:textSize="20sp"  
    android:inputType="text|number"  
     />
```

Now we will be adding ==RadioGroup== to place the ==RadioButton== 's inside it. And set it below the EditText box in interface.
```xml
<RadioGroup  
    android:id="@+id/radioG"  
    android:layout_width="239dp"  
    android:layout_height="209dp"  
    android:layout_marginTop="72dp"  
    >
</RadioGroup>
```

Place the ==RadioButton's== inside the RadioGroup in interface and xml.
```xml
<RadioButton  
    android:id="@+id/radioButton"  
    android:layout_width="match_parent"  
    android:layout_height="wrap_content"  
    android:text="USD" />  
  
<RadioButton  
    android:id="@+id/radioButton2"  
    android:layout_width="match_parent"  
    android:layout_height="wrap_content"  
    android:text="EURO" />  
  
<RadioButton  
    android:id="@+id/radioButton3"  
    android:layout_width="match_parent"  
    android:layout_height="wrap_content"  
    android:text="YEN" />
```

Lets place a TextView below the RadioGroup in interface, to display the result after the ==Button== has been clicked which will be adding next.
```xml
<TextView  
    android:id="@+id/Result"  
    android:layout_width="wrap_content"  
    android:layout_height="wrap_content"  
    android:layout_marginTop="56dp"  
    android:text="Result"  
    android:textSize="30sp"  
     />
```

Its time to add the ==Button== , when triggered will display the result in TextView. Place the Button below the result in interface.
```xml
<Button  
    android:id="@+id/ConvertB"  
    android:layout_width="146dp"  
    android:layout_height="58dp"  
    android:text="Convert"  
     />
```

### Interface 

>Click on the Infer Constraints, check the description if you are not familier 

This is the result after applying the above code above xml code ignore the signs of currency

![Pasted image 20230220233124](https://user-images.githubusercontent.com/118284932/220184329-39d26871-4aa9-4bdd-b8bd-835afce8925e.png)

This was it for the interface requirement. If you want add some more symbols and texts you can to make it look more interactive rather than boring and in project some extra signs are been added you can check for that. Now lets begin with the logic through ==Java== .


## Java Code
---
>MainActivity.java


We will work with default java code.
```Java
package com.example.currency_converter;  
  
import androidx.appcompat.app.AppCompatActivity;  
  
import android.os.Bundle;  
import android.view.View;  
import android.widget.Button;  
import android.widget.EditText;  
import android.widget.RadioButton;  
import android.widget.RadioGroup;  
import android.widget.TextView;  

// Code to Convert Currencies  
  
public class MainActivity extends AppCompatActivity {
	@Override  
	protected void onCreate(Bundle savedInstanceState) {  
	    super.onCreate(savedInstanceState);  
	    setContentView(R.layout.activity_main);
	}
}
```

First of all delcare all the variables needed to connect with the xml components.
```Java
public class MainActivity extends AppCompatActivity {
	EditText input;  
	TextView result;  
	RadioGroup radioG;  
	Button convertButton;  
	RadioButton optionButton;  
	Double Amt=0.0,rs;
	@Override  
	protected void onCreate(Bundle savedInstanceState) {  
	    super.onCreate(savedInstanceState);  
	    setContentView(R.layout.activity_main);
	}
}
```

Now connect all the components of xml to java using ==findViewById()== 
*Note: if  we miss to connect any component, the app will start crashing byitself*
```Java
protected void onCreate(Bundle savedInstanceState) {  
    super.onCreate(savedInstanceState);  
    setContentView(R.layout.activity_main);  
  
    // mapping input out & option group  
    input = findViewById(R.id.inputb);  
    result = findViewById(R.id.Result);  
    radioG = findViewById(R.id.radioG);  
  
    // Button to trigger convert the currency  
    convertButton = findViewById(R.id.ConvertB);
}
```

So now we are set to get the input from user. Lets setup the button to fetch the value, compute the value and display the result. We will using ==setOnClickListener()== to check wether the button was clicked.
```Java
protected void onCreate(Bundle savedInstanceState) {  
    super.onCreate(savedInstanceState);  
    setContentView(R.layout.activity_main);  
  
    // mapping input out & option group  
    input = findViewById(R.id.inputb);  
    result = findViewById(R.id.Result);  
    radioG = findViewById(R.id.radioG);  
  
    // Button to trigger convert the currency  
    convertButton = findViewById(R.id.ConvertB);
    convertButton.setOnClickListener(new View.OnClickListener() {  
	    @Override  
	    public void onClick(View view) {
		}
	});
}
```

Now we have to setup the computation and result display inside the Listener itself.
We will write the code to find out which option was clicked.
```Java
convertButton.setOnClickListener(new View.OnClickListener() {  
    @Override  
    public void onClick(View view) {  
  
        // to check which option is click and get its id  
        int id = radioG.getCheckedRadioButtonId();  
        // mapping the id to get the radio button  
        optionButton =  findViewById(id);
    }
}
```

We will fetch the number given by user by using ==getText()== .
```Java
convertButton.setOnClickListener(new View.OnClickListener() {  
    @Override  
    public void onClick(View view) {  
  
        // to check which option is click and get its id  
        int id = radioG.getCheckedRadioButtonId();  
        // mapping the id to get the radio button  
        optionButton =  findViewById(id);  
  
        // fetching the value given by user  
        rs = Double.parseDouble(input.getText().toString());
    }
});
```

After this we use input and id collected from RadioGroup to compute the currecny. And display it on the TextView.
```Java
convertButton.setOnClickListener(new View.OnClickListener() {  
    @Override  
    public void onClick(View view) {  
  
        // to check which option is click and get its id  
        int id = radioG.getCheckedRadioButtonId();  
        // mapping the id to get the radio button  
        optionButton =  findViewById(id);  
  
        // fetching the value given by user  
        rs = Double.parseDouble(input.getText().toString());  
  
        // checking for the radio button by its id and name  
        if(optionButton.getText().toString().equals("USD")){  
            // Calculating the amount  
            Amt=rs/80;  
        }  
  
        if(optionButton.getText().toString().equals("EURO")){  
            Amt=rs/90;
        }  
  
        if(optionButton.getText().toString().equals("YEN")){  
            Amt= rs/0.62; 
        }  
  
        // converting the double value to float  
        Float Amount = Amt.floatValue();  
  
        // setting the amount to TextView  
        result.setText(String.valueOf(Amount));  
    }  
});
```

Now run the app and you are ==Done!== .


## Output Screen
---
> The design may differ according to your contraints and device, Also i have added extra signs using TextView.


![Pasted image 20230220233615](https://user-images.githubusercontent.com/118284932/220184300-d3536959-c4da-4df2-8e44-1330d98fd9f4.png)



## Discription
---
>The information has been fetched from [Android Developer offical website](https://www.googleadservices.com/pagead/aclk?sa=L&ai=DChcSEwi3v4eu26T9AhXPmWYCHRMSCdUYABAAGgJzbQ&ohost=www.google.com&cid=CAESauD2YhC7e5eOBN4zTXQALsU8kaXGeZ3jU4VHsZPy0f6efdE7c8dI2yg23AsbPfRwjKzpzHK5BRpLBQq2QPPhYekluGqgpHCc1RtTHWzQ5oJe1SOpsr_M1liYG7IYhYunG3hmmvtwA96cvMM&sig=AOD64_0szIa-JPLDz2PrlTxMD4QzRoROFg&q&adurl&ved=2ahUKEwjv8oCu26T9AhUQwjgGHWtcA08Q0Qx6BAgJEAE)

| Syntax | About it |
| --- | --- |
| [EditText](https://developer.android.com/reference/android/widget/EditText) | A user interface element for entering and modifying text. When you define an edit text widget, you must specify the [R.styleable.TextView_inputType](https://developer.android.com/reference/android/R.styleable#TextView_inputType) attribute. For example, for plain text input set inputType to "text":|
| [TextView](https://developer.android.com/reference/android/widget/TextView) | A user interface element that displays text to the user. |
| [Button](https://developer.android.com/develop/ui/views/components/button) |  A button consists of text or an icon (or both text and an icon) that communicates what action occurs when the user touches it.|
| [RadioGroup](https://developer.android.com/reference/android/widget/RadioGroup) | This class is used to create a multiple-exclusion scope for a set of radio buttons. Checking one radio button that belongs to a radio group unchecks any previously checked radio button within the same group.|
| [Radio Buttons](https://developer.android.com/develop/ui/views/components/radiobutton#:~:text=Radio%20buttons%20allow%20the%20user,side%2C%20use%20a%20spinner%20instead.)| Radio buttons allow the user to select one option from a set. You should use radio buttons for optional sets that are mutually exclusive if you think that the user needs to see all available options side-by-side.|

If you have further more doubts just visit the [Android Developer Website.](https://www.googleadservices.com/pagead/aclk?sa=L&ai=DChcSEwi3v4eu26T9AhXPmWYCHRMSCdUYABAAGgJzbQ&ohost=www.google.com&cid=CAESauD2YhC7e5eOBN4zTXQALsU8kaXGeZ3jU4VHsZPy0f6efdE7c8dI2yg23AsbPfRwjKzpzHK5BRpLBQq2QPPhYekluGqgpHCc1RtTHWzQ5oJe1SOpsr_M1liYG7IYhYunG3hmmvtwA96cvMM&sig=AOD64_0szIa-JPLDz2PrlTxMD4QzRoROFg&q&adurl&ved=2ahUKEwjv8oCu26T9AhUQwjgGHWtcA08Q0Qx6BAgJEAE)

**Thank You.**

---
>GitHub [@RionDsilvaCS](https://github.com/RionDsilvaCS)  ·  Linkedin [@Rion Dsilva](https://www.linkedin.com/in/rion-dsilva-043464229/)


