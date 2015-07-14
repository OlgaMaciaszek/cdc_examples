import groovy.transform.Field

@Field
public static final String PESEL_REGEXP = '[0-9]{11}'

@Field
public static final String SMALL_AMOUNT_REGEXP = '[1-9]{5}'

io.codearte.accurest.dsl.GroovyDsl.make {
    request {
        method """PUT"""
        url """/fraudcheck"""
        body(
                clientPesel: value(client(regex(PESEL_REGEXP)), server("12345678902")),
                loanAmount: value(client(regex(SMALL_AMOUNT_REGEXP)), server(99999))
        )
        headers {
            header("""Content-Type""", """application/vnd.fraud.v1+json""")

        }

    }
    response {
        status 200
        body("""{
    "fraudCheckStatus": "FRAUD",
    "rejectionReason": "Amount too high"
}""")
        headers {
            header('Content-Type': 'application/vnd.fraud.v1+json')

        }

    }

}
