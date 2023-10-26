package br.edu.ifpi.poo.entidades;

public class Adress {
        private String street;
        private int number;
        private String district;
        private String city;
        private String state;
        private String country;
    
        public Adress(String street, int number, String district, String city, String state, String country) {
            this.street = street;
            this.number = number;
            this.district = district;
            this.city = city;
            this.state = state;
            this.country = country;
        }

        // getters e setters
        public String getstreet() {
            return street;
        }

        public void setstreet(String street) {
            this.street = street;
        }

        public int getnumber() {
            return number;
        }

        public void setnumber(int number) {
            this.number = number;
        }

        public String getdistrict() {
            return district;
        }

        public void setdistrict(String district) {
            this.district = district;
        }

        public String getcity() {
            return city;
        }

        public void setcity(String city) {
            this.city = city;
        }

        public String getstate() {
            return state;
        }

        public void setstate(String state) {
            this.state = state;
        }

        public String getcountry() {
            return country;
        }

        public void setcountry(String country) {
            this.country = country;
        }

    
        @Override
        public String toString() {
            return street + ", " + number + ", " + district + ", " + city + ", " + state + ", " + country;
        }
    }