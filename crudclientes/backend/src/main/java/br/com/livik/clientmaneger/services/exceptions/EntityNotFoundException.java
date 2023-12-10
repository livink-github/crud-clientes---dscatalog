package br.com.livik.clientmaneger.services.exceptions;

public class EntityNotFoundException extends RuntimeException {
   private static final long serialVersionUID = 1L;
   
   public EntityNotFoundException(String exceptionMsg) {
	   super(exceptionMsg);
   }
}
