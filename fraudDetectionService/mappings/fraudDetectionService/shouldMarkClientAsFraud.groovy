import groovy.transform.Field

@Field
public static final String PESEL_REGEXP = '[0-9]{11}'

@Field
public static final String HIGH_AMOUNT_REGEXP = '[1-9]{5}'

io.codearte.accurest.dsl.GroovyDsl.make {
	request {
		method 'PUT'
		url '/fraudcheck'
		body(
				clientPesel: value(stub(regex(PESEL_REGEXP)), test("12345678902")),
				loanAmount: value(stub(regex(HIGH_AMOUNT_REGEXP)), test(99999))
		)
		headers {
			header('Content-Type', 'application/vnd.fraud.v1+json')

		}

	}
	response {
		status 200
		body(fraudCheckStatus: "FRAUD",
				rejectionReason: "Amount too high")
		headers {
			header('Content-Type': 'application/vnd.fraud.v1+json')

		}

	}

}
