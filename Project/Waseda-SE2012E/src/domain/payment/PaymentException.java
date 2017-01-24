/*
 * Copyright(C) 2007-2013 National Institute of Informatics, All rights reserved.
 */
package domain.payment;

import java.util.ArrayList;
import java.util.List;

/**
 * Exception specific to payment
 * 
 */
public class PaymentException extends Exception {

	private List detailMessages = new ArrayList();

	public static final int CODE_PAYMENT_NOT_FOUND = 1;

	public static final int CODE_PAYMENT_ALREADY_CONSUMED = 2;

	public static final int CODE_DB_EXEC_QUERY_ERROR = 3;

	public static final int CODE_DB_CONNECT_ERROR = 4;

	public static final int CODE_DB_CLOSE_ERROR = 5;

	private static final String MESSAGE_PAYMENT_NOT_FOUND = "該当する請求データが見つかりませんでした";

	private static final String MESSAGE_PAYMENT_ALREADY_CONSUMED = "該当する請求データは、既に消化されています";

	private static final String MESSAGE_DB_EXEC_QUERY_ERROR = "クエリー実行時にエラーが発生しました";

	private static final String MESSAGE_DB_CONNECT_ERROR = "データベースに接続できませんでした";

	private static final String MESSAGE_DB_CLOSE_ERROR = "データベースの接続を切断できませんでした";

	private int code;

	public PaymentException(int code) {
		super();
		this.code = code;
	}

	public PaymentException(int code, Throwable cause) {
		super(cause);
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		String result = null;
		switch (code) {
			case CODE_PAYMENT_NOT_FOUND:
				result = MESSAGE_PAYMENT_NOT_FOUND;
				break;
			case CODE_PAYMENT_ALREADY_CONSUMED:
				result = MESSAGE_PAYMENT_ALREADY_CONSUMED;
				break;
			case CODE_DB_EXEC_QUERY_ERROR:
				result = MESSAGE_DB_EXEC_QUERY_ERROR;
				break;
			case CODE_DB_CONNECT_ERROR:
				result = MESSAGE_DB_CONNECT_ERROR;
				break;
			case CODE_DB_CLOSE_ERROR:
				result = MESSAGE_DB_CLOSE_ERROR;
				break;
			default:
				result = "";
				break;
		}
		return result;
	}

	public List getDetailMessages() {
		return detailMessages;
	}
}
