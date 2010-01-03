package madvirus.spring.chap06.validator;

import madvirus.spring.chap06.model.Address;
import madvirus.spring.chap06.model.MemberInfo;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class MemberInfoValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return MemberInfo.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		MemberInfo memberInfo = (MemberInfo) target;
		if (memberInfo.getId() == null || memberInfo.getId().trim().isEmpty()) {
			errors.rejectValue("id", "id.required");
		}
		if (memberInfo.getName() == null
				|| memberInfo.getName().trim().isEmpty()) {
			errors.rejectValue("name", "name.required");
		}
		Address address = memberInfo.getAddress();
		if (address == null) {
			errors.rejectValue("address", "address.required");
		}
		if (address != null) {
			if (address.getZipcode() == null
					|| address.getZipcode().trim().isEmpty()) {
				errors.rejectValue("address.zipcode",
						"address.zipcode.required");
			}
			if (address.getAddress1() == null
					|| address.getAddress1().trim().isEmpty()) {
				errors.rejectValue("address.address1",
						"address.address1.required");
			}
		}
	}

}
