package com.example.user.firelogin;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

/**
 * Created by USER on 26.7.2017.
 */

public class Product {
    @SerializedName("code")
    public String Code;


    @SerializedName("ingredients_text_with_allergens")
    public String ingredients_text_with_allergens;

    @SerializedName("nutrition_grades")
    public String nutrition_grades ;

    @SerializedName("nutriments")
    public Map<String,String> nutriments ;


    public  String GetProteinIn100g()
    {
        return   this.nutriments.get("proteins_100g");
    }

    public String GetCarbonhydrateIn100g()
    {
        return this.nutriments.get("carbohydrates_100g");
    }

    public String GetEnergyIn100g()
    {
        return this.nutriments.get("energy_100g");
    }

    public String GetSugarsIn100g()
    {
        return this.nutriments.get("sugars_100g");
    }

    public String GetFatIn100g()
    {
        return this.nutriments.get("fat_100g");
    }

}
