package contracts;

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    label('triggerCreateUser')
    input {
        messageFrom('receiveUser-in-0')
        messageBody([
                id     : 1,
                name   : 'John Doe',
                address: 'Test Street'
        ])
//        triggeredBy('triggerCreateUser()')
    }
    outputMessage {
        sentTo('users')
        body([
                id     : 1,
                name   : 'John Doe',
                address: 'Test Street'
        ])
    }
}
