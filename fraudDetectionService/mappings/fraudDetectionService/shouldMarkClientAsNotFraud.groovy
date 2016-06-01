import groovy.transform.Field

@Field
public static final String ID_REGEXP = '[0-9]{11}'

io.codearte.accurest.dsl.Accurest.make {
  request {
    method 'PUT'
    url '/fraudcheck'
    body(
        clientPesel: value(client(regex(ID_REGEXP)), server("12345678902")),
        loanAmount: 123.123
    )
    headers {
      header('Content-Type', 'application/vnd.fraud.v1+json')

    }

  }
  response {
    status 200
    body(
        "fraudCheckStatus": "OK",
        "rejectionReason": null)
    headers {
      header('Content-Type': 'application/vnd.fraud.v1+json')

    }

  }

}
