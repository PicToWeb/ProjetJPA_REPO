package com.imdb.jpa.services.parseCSV;

import com.imdb.jpa.entities.Address;
import com.imdb.jpa.entities.Country;

public abstract class AddressReader {


    /**
     * Static Method used to parse an adress line and create an Adress Object
     * adress column call a static Method from CountryReaderCsv to parse and
     * transform "String" in "Adress" Object
     *
     * @param line received from ActorReaderCsv, ProducerReaderCsv
     * @return Adress Object
     */
    public static Address parseLine(String line) {
        Address address = new Address();
        String[] column = line.split(",");

        switch (column.length) {
            case 1:
                address.setCity("");
                address.setEtat("");
                address.setCountry(new Country(CountryReader.formatAbvName(column[0]),""));
                break;
            case 2:
                address.setCity(column[0]);
                address.setEtat("");
                address.setCountry(new Country(CountryReader.formatAbvName(column[1]),""));
                break;
            case 3:
                address.setCity(column[0]);
                address.setEtat(column[1]);
                address.setCountry(new Country(CountryReader.formatAbvName(column[2]),""));
                break;
            case 4:
                address.setCity(column[0] + "-" + column[1]);
                address.setEtat(column[2]);
                address.setCountry(new Country(CountryReader.formatAbvName(column[3]),""));
                break;
            case 5:
                address.setCity(column[0] + "-" + column[1]);
                address.setEtat(column[2] + "-" + column[3]);
                address.setCountry(new Country(CountryReader.formatAbvName(column[4]),""));
                break;
            default:
                break;
        }
        address.setStreet("");
        return address;
    }

    /**
     * Static Method used to parse an adress line and create an Adress Object
     * adress column call a static Method from CountryReaderCsv to parse and
     * transform "String" in "Adress" Object
     *
     * @param line received from MovieReaderCsv
     * @return Adress Object
     */
    public static Address parseLineReverse(String line) {
        Address address = new Address();
        String[] column = line.split("[,\\-]");

        switch (column.length) {
            case 1:
                address.setCity("");
                address.setEtat("");
                break;
            case 2:
                address.setEtat(column[1]);
                address.setCity("");
                break;
            case 3:
                address.setEtat(column[1]);
                address.setCity(column[2]);

                break;
            case 4:
                address.setEtat(column[1]);
                address.setCity(column[2]);
                address.setStreet(column[3]);
                break;
            case 5:
                address.setEtat(column[1]);
                address.setCity(column[2]);
                address.setStreet(column[3] + " " + column[4]);
                break;
            default:
                break;
        }
        address.setCountry(new Country(CountryReader.formatAbvName(column[0]),""));
        return address;
    }
}
