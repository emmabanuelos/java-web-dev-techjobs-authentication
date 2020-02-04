package org.launchcode.javawebdevtechjobsauthentication.models.data;

import org.launchcode.javawebdevtechjobsauthentication.models.AbstractEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;


    @Entity
    public class User extends AbstractEntity {

        @NotBlank
        private String username;

        @NotBlank
        private String pwHash;

        public User() {}


        private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        public User(String username, String password) {
            this.username = username;
            this.pwHash = encoder.encode(password);
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPwHash() {
            return pwHash;
        }

        public void setPwHash(String pwHash) {
            this.pwHash = pwHash;
        }

        public boolean isMatchingPassword(String password) {
            return encoder.matches(password, pwHash);
        }

    }

