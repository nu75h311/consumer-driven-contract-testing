import org.springframework.cloud.contract.spec.Contract

Contract.make {
    label("score_of_high_input_output")
    input {
        messageFrom('credit_score_requests')
        messageBody(
                citizenNumber : 1234,
                uuid : $(c(regex(uuid())), p("29799ba2-b8db-4a98-8d12-46e09e129122"))
        )
    }
    outputMessage {
        sentTo("credit_scores")
        body(
                score : "HIGH",
                uuid: "29799ba2-b8db-4a98-8d12-46e09e129122"
        )
        headers {
            header("contentType", applicationJson())
        }
    }
}