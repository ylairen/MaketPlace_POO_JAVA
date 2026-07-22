package service;

import java.util.Random;
import java.util.UUID;

public class IdService {
	
	//Usando Random
	
	public static final Random random = new Random();
	
	public static String gerarId(){
		int id = random.nextInt(9000)+1000;
		return String.valueOf(id);
	}
	/*
	//Usando o UUID
	public static String gerarId(){
		final int id = Math.abs(UUID.randomUUID().hashCode());
		return String.valueOf(id);
	}
*/
}
