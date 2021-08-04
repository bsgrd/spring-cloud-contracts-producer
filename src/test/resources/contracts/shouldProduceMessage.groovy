package contracts;

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    label('triggerCreateUser')
    input {
        messageFrom("sendUser-in-0")
        messageBody([
                id     : 1,
                name   : "John Doe",
                address: "Test Street"
        ])
//        triggeredBy('triggerCreateUser()')
    }
    outputMessage {
        sentTo('sendUser-out-0')
        body([
                id     : 1,
                name   : "John Doe",
                address: "Test Street"
        ])
    }
}
