package com.Meta_Keiber.SpringBoot.api.exections;

public class BadRequestException 
    extends RuntimeException {
    
        public BadRequestException(String message){
            super(message);
        }
}
