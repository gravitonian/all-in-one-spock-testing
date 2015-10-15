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

import spock.lang.Specification

class PubSubTestSpec extends Specification {
    def publisher = new Publisher()
    def subscriber1 = Mock(Subscriber)
    def subscriber2 = Mock(Subscriber)

    def setup() {
        publisher.subscribers << subscriber1 << subscriber2
    }

    def "Deliver an event to all subscribers"() {
        setup:
        def event = "someEvent"

        when:
        publisher.send(event)

        then:
        1 * subscriber1.receive(event)
        1 * subscriber2.receive(event)
        0 * _
    }

    def "Make sure we can deal with one subscriber misbehaving"() {
        subscriber1.receive(_) >> { throw new Exception() }

        setup:
        def event = "someEvent"
        def event2 = "someEvent2"

        when:
        publisher.send(event)
        publisher.send(event2)

        then:
        1 * subscriber2.receive(event)
        1 * subscriber2.receive(event2)
    }
}

class Publisher {
    def subscribers = []

    def send(event) {
        subscribers.each {
            try {
                it.receive(event)
            } catch (Exception e) {e.printStackTrace()}
        }
    }
}
interface Subscriber {
    def receive(event)
}

