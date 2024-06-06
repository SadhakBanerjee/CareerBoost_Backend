//package com.careerboost.entity;
//
//public class JwtResponse {
//
//	
//	    private String jwtToken;
//	    private String username;
//
//	    public JwtResponse() {
//	    }
//
//	    public JwtResponse(String jwtToken, String username) {
//	        this.jwtToken = jwtToken;
//	        this.username = username;
//	    }
//
//	    // Getters and setters
//
//	    public String getJwtToken() {
//	        return jwtToken;
//	    }
//
//	    public void setJwtToken(String jwtToken) {
//	        this.jwtToken = jwtToken;
//	    }
//
//	    public String getUsername() {
//	        return username;
//	    }
//
//	    public void setUsername(String username) {
//	        this.username = username;
//	    }
//
//	    // Builder pattern implementation
//	    public static JwtResponseBuilder builder() {
//	        return new JwtResponseBuilder();
//	    }
//
//	    public static class JwtResponseBuilder {
//	        private String jwtToken;
//	        private String username;
//
//	        public JwtResponseBuilder jwtToken(String jwtToken) {
//	            this.jwtToken = jwtToken;
//	            return this;
//	        }
//
//	        public JwtResponseBuilder username(String username) {
//	            this.username = username;
//	            return this;
//	        }
//
//	        public JwtResponse build() {
//	            return new JwtResponse(jwtToken, username);
//	        }
//	    }
//}

package com.careerboost.entity;

public class JwtResponse {

    private String jwtToken;
    private String username;
    private String message;
    
    public JwtResponse() {
    }

    public JwtResponse(String jwtToken, String username, String message) {
        this.jwtToken = jwtToken;
        this.username = username;
        this.message = message;
    }

    // Getters and setters

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    // Builder pattern implementation
    public static JwtResponseBuilder builder() {
        return new JwtResponseBuilder();
    }

    public static class JwtResponseBuilder {
        private String jwtToken;
        private String username;
        private String message;

        public JwtResponseBuilder jwtToken(String jwtToken) {
            this.jwtToken = jwtToken;
            return this;
        }

        public JwtResponseBuilder username(String username) {
            this.username = username;
            return this;
        }

        public JwtResponseBuilder message(String message) {
            this.message = message;
            return this;
        }

        public JwtResponse build() {
            return new JwtResponse(jwtToken, username, message);
        }
    }
}


