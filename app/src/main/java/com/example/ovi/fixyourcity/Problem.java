package com.example.ovi.fixyourcity;

/**
 * Created by Ovi on 4/1/2018.
 */

public class Problem {
        private int id;
        private String date;
        private User user;
        private String description;
        private String longitude;
        private String latitude;
        private Status status;


        public Problem(String string, User user, String description, String longitude, String latitude, Status status) {
            this.status = status;
            this.setDate(string);
            this.user = user;
            this.description = description;
            this.latitude = latitude;
            this.longitude = longitude;

        }

    public Problem() {

    }

    public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String string) {
            this.date = string;
        }

        public Status getStatus() {
            return status;
        }

        public void setStatus(Status status) {
            this.status = status;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }