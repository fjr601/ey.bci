package cl.ey.bci.util;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class Util {
	private static String secretKey = "eyJhbGciOiJIUzUxMiJ9eyJSb2xlIjoiQWRtaW4iLCJJc3N1ZXIiOiJJc3N1ZXIiLCJVc2VybmFtZSI6IkphdmFJblVzZSIsImV4cCI6MTY4MTM5Njc0NSwiaWF0IjoxNjgxMzk2NzQ1fQSU9quuOwiVZl0pw2ww4iKVLquBYM1PcyY3CPikOZtZgcCkrmpfaXacB4oWClwgqcuMCWfi5qopTBkxxgCrg";
	private static long expirationTime = 86400000;

	@SuppressWarnings("deprecation")
	public static String generateToken(String email) {
		Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);

		String token = Jwts.builder().setSubject(email).setExpiration(expirationDate)
				.signWith(SignatureAlgorithm.HS512, secretKey).compact();
		return token;
	}

	public static boolean validateEmail(String email) {
		String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
		Pattern emailPattern = Pattern.compile(emailRegex);
		Matcher matcher = emailPattern.matcher(email);
		boolean isValid = matcher.matches();
		return isValid;
	}

	public static boolean validatePassword(String password) {
		// Una mayuscula, letras minusculas, 2 numeros, longitud 6		                   
		String passRegex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d.*\\d)[A-Za-z\\d]+$";
		Pattern passPattern = Pattern.compile(passRegex);
		Matcher matcher = passPattern.matcher(password);
		boolean isValid = matcher.matches();
		return isValid;
	}

}
