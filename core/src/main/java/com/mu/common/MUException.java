package com.mu.common;

public class MUException extends Exception {
	private static final long serialVersionUID = 1L;
	
		/**
		 * Default Constructor.
		 */
		public MUException() {
			super();
		}

		/**
		 * <p>
		 * Constructor with one Argument.
		 * </p>
		 * 
		 * @param msg - a String Value - Exception message
		 */
		public MUException(final String msg) {
			super(msg);
		}

		/**
		 * Constructor with two Argument.
		 * 
		 * @param msg - a String Value - Exception message
		 * @param cause -Throwable object
		 */
		public MUException(final String msg, final Throwable cause) {
			super(msg, cause);
		}

		/**
		 * Constructor with one Argument.
		 * 
		 * @param cause - Throwable object
		 */
		public MUException(final Throwable cause) {
			super(cause);
		}

}
