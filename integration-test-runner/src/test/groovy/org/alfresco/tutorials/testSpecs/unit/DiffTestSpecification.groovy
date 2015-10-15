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

import groovy.transform.Canonical
import spock.lang.Specification

class DiffTestSpecification extends Specification {
    def "Compare Sets"() {
        expect:
        ["alfresco", "shdare", "site"] as Set == ["alfresco", "share", "ssite"] as Set
    }

    def "Compare POJOs"() {
        setup:
        def person1 = new Person(firstname: "Fredd", lastname: "Blogs", email: "fred.blogs@alfresco.com", age: 32)
        def person2 = new Person(firstname: "Fred", lastname: "Blozgs", email: "fred.blogs@alfresco.com", age: 35)

        expect:
        person1 == person2
    }

    def "Compare Text"() {
        expect:
        generateLoremIpsum() ==
                """Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur quis ante porttitor,
                  mattis erat sit amet, tristique lacus. Cras aliquet, lectus ac porta varius, lorem augue
                  scelerisque mi, vitae finibus nulla tellus id nunc. Cras vestibulum nisl a aliquam sodales.
                  Fusce non ultrices urna. Duis euismod luctus eros, newwc bibendum quam scelerisque quis.
                  Suspendisse ac nibh nec sssleo volutpat fermentum et eget velit. Ut placerat ipsum a justo dictum,
                  vitae placerat orci sodales. Etiam fringilla mi ac viverra vestibulum.
                  Duis laoreet sagittis tempor. Etiam consequat mi quis metus lacinia, vel lacinia velit iaculis.
                  Proin eu egestas risus, quis porta est. Phasellus at odio est. Nullam sit amet turpis laoreet tortor
                  ornare volutpat non sed mauris. Maecenas eget ornare est, utddd bibendum ex. Integer libero felis,
                  ullamcorper fermentum dui sit amet, lacinia mattis sem. Donec malesuada ligula non tristique maximus."""

    }

    private generateLoremIpsum() {
        return """Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur quis ante porttitor,
                  mattis erat sit amet, tristique lacus. Cras aliquet, lectus ac porta varius, lorem augue
                  scelerisque mi, vitae finibus nulla tellus id nunc. Cras vestibulum nisl a aliquam sodales.
                  Fusce non ultrices urna. Duis euismod luctus eros, nec bibendum quam scelerisque quis.
                  Suspendisse ac nibh nec leo volutpat fermentum et eget velit. Ut placerat ipsum a justo dictum,
                  vitae placerat orci sodales. Etiam fringilla mi ac viverra vestibulum.
                  Duis laoreet sagittis tempor. Etiam consequat mi quis metus lacinia, vel lacinia velit iaculis.
                  Proin eu egestas risus, quis porta est. Phasellus at odio est. Nullam sit amet turpis laoreet tortor
                  ornare volutpat non sed mauris. Maecenas eget ornare est, ut bibendum ex. Integer libero felis,
                  ullamcorper fermentum dui sit amet, lacinia mattis sem. Donec malesuada ligula non tristique maximus."""
    }
}

@Canonical
class Person {
    String firstname
    String lastname
    String email
    int age
}