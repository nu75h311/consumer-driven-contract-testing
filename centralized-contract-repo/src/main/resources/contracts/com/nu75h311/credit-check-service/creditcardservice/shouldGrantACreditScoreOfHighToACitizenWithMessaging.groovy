import org.springframework.cloud.contract.spec.Contract

Contract.make {
    label("score_of_high")
    outputMessage {
        sentTo("credit_scores")
        body(
                score : "HIGH",
                uuid: "67bb6459-b718-4cbd-b015-6fc80aef7d31"
        )
        headers {
            header("contentType", applicationJsonUtf8())
        }
    }
}