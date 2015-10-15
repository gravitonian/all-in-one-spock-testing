/**
 * Copyright (C) 2015 Alfresco Software Limited.
 *
 * This file is part of the Alfresco SDK Samples project.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.alfresco.tutorials.testSpecs.unit

import org.alfresco.tutorial.Account
import org.alfresco.tutorial.NegativeAmountWithdrawException
import spock.lang.Specification

class AccountTestSpec extends Specification {
    def "Withdraw some money"() {
        given:
        def account = new Account(5.0)

        when:
        account.withdraw(2.0)

        then:
        account.balance == 3.0
    }

    def "Withdraw negative amount"() {
        given:
        def account = new Account(5.0)

        when:
        account.withdraw(-2.0)

        then:
        NegativeAmountWithdrawException e = thrown()
        e.amount == -2.0
    }
}