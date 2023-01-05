package CarRentalSystem.models;

import CarRentalSystem.models.enums.AddOnType;
import CarRentalSystem.models.enums.HelmetType;

public class Helmet extends AddOns{
    String id;
    HelmetType helmetType;
    AddOnType addOnType = AddOnType.HELMET;
    double price;
}
