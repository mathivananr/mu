package com.mu.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.mu.Constants;
import com.mu.common.MUException;
import com.mu.model.Payment;

public final class StringUtil {

	public StringUtil() {
	}

	public static boolean isEmptyString(String s) {
		if ((s == null) || (s.trim().length() == 0)) {
			return (true);
		} else {
			return (false);
		}
	}

	public static boolean isEmptyString(final Object object) {
		if ((object == null) || (object.toString().trim().length() == 0)) {
			return true;
		}
		return false;
	}

	public static boolean containsValue(final String[] values,
			final String value) {
		if (values == null) {
			return false;
		}

		for (int i = 0; i < values.length; i++) {
			if (value.equals(values[i])) {
				return true;
			}
		}

		return false;
	}

	public static boolean containsValues(final String[] s, final int beginIndex) {
		if ((s == null) || (s.length == 0)) {
			return false;
		}

		if (s.length <= beginIndex) {
			return false;
		}

		boolean flag = false;

		for (int i = beginIndex; i < s.length; i++) {
			if (!isEmptyString(s[i])) {
				flag = true;

				break;
			}
		}

		return flag;
	}

	public static String toCSL(final String[] s) {
		StringBuffer buf = new StringBuffer("");

		if ((s != null) && (s.length > 0)) {
			for (int i = 0; i < s.length; i++) {
				if (!isEmptyString(s[i])) {
					buf.append(s[i]);

					if ((i < (s.length - 1)) && containsValues(s, i + 1)) {
						buf.append(", ");
					}
				}
			}
		}

		return buf.toString().trim();
	}

	public static String toCSL(final String[] s, final String delimiter) {
		StringBuffer buf = new StringBuffer("");

		if ((s != null) && (s.length > 0)) {
			if (!isEmptyString(s[0])) {
				buf.append(s[0]);
			}

			for (int i = 1; i < s.length; i++) {
				if (!isEmptyString(s[i])) {
					buf.append(delimiter);
					buf.append(s[i]);
				}
			}
		}

		return buf.toString().trim();
	}

	public static String toCSL(final List l, final String delimiter) {
		String[] tmp = new String[1];

		return toCSL((String[]) l.toArray(tmp), delimiter);
	}

	public static String toCSL(final List list) {
		String[] s = new String[list.size()];
		s = (String[]) list.toArray(s);

		return toCSL(s);
	}

	public static boolean isURL(String value) {
		String parrern = "^(ftp|http|https)://([^/]+)(/.*)?";
		Pattern p = Pattern.compile(parrern);
		Matcher m = p.matcher(value);
		return m.matches();
	}

	public static boolean isEmail(String value) {
		String parrern = "[a-z0-9\\.\\-\\_]+@([a-z0-9\\-\\_]+\\.)+(com|org|info|net|[a-z]{2,4})";
		Pattern p = Pattern.compile(parrern);
		Matcher m = p.matcher(value);
		return m.matches();
	}

	public static boolean isValidMobileNo(final String number) {
		int length = number.length();
		String mobileFormat = "^[+]?(91[\\-\\s]?)?[0-9]{10}+$";
		Pattern pattern = Pattern.compile(mobileFormat);
		Matcher matcher = pattern.matcher(number);
		return matcher.matches();
	}

	public static String getCommaSeparatedString(List<String> listOfString) {
		StringBuffer stringBuffer = new StringBuffer();
		int size = 0;
		for (String element : listOfString) {
			if (stringBuffer.indexOf(element) == -1) {
				if (stringBuffer.length() > 0) {
					stringBuffer.append(",");
				}
				stringBuffer.append("'");
				stringBuffer.append(element);
				stringBuffer.append("'");
				size = size + 1;
			}
		}
		return stringBuffer.toString();
	}

	/**
	 * generate hash for payumoney
	 * 
	 * @param payment
	 * @return
	 * @throws MUException
	 */
	public static String generateHash(Payment payment) throws MUException {
		StringBuffer hashString = new StringBuffer();
		hashString.append(payment.getKey());
		hashString.append("|");
		hashString.append(payment.getTxnid());
		hashString.append("|");
		hashString.append(payment.getAmount());
		hashString.append("|");
		hashString.append(payment.getProductinfo());
		hashString.append("|");
		//hashString.append(payment.getFirstname());
		hashString.append("|");
		hashString.append(payment.getEmail());
		hashString.append("|||||||||||");
		if (Constants.IS_TEST_APP) {
			hashString.append(Constants.PY_TEST_SALT);
		} else {
			hashString.append(Constants.PY_LIVE_SALT);
		}
		System.out.println("hash string =========="+ hashString.toString());
		return hashCal(Constants.PY_ENCRYPT_TYPE, hashString.toString());
	}

	/**
	 * encrypt hash string
	 * 
	 * @param type
	 * @param str
	 * @return
	 * @throws MUException
	 */
	public static String hashCal(String type, String str) throws MUException {
		byte[] hashseq = str.getBytes();
		StringBuffer hexString = new StringBuffer();
		try {
			MessageDigest algorithm = MessageDigest.getInstance(type);
			algorithm.reset();
			algorithm.update(hashseq);
			byte messageDigest[] = algorithm.digest();

			for (int i = 0; i < messageDigest.length; i++) {
				String hex = Integer.toHexString(0xFF & messageDigest[i]);
				if (hex.length() == 1)
					hexString.append("0");
				hexString.append(hex);
			}

		} catch (NoSuchAlgorithmException nsae) {
			throw new MUException("problem in generate payment hash ", nsae);
		}

		return hexString.toString();

	}
}
