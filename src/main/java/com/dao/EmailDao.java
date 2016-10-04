package com.dao;

import com.models.Email;
import com.response.Response;

public interface EmailDao {

	public Response sendEmail(Email email);
}
