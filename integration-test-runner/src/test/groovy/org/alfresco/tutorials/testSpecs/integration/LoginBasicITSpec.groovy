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
package org.alfresco.tutorials.testSpecs.integration

import geb.spock.GebReportingSpec

class LoginBasicITSpec extends GebReportingSpec {
    def "Test valid login"() {
        when: "I navigate to the login page"
        go  "page"

        then: "a page with login title appears"
        title.contains("Alfresco » Login")

        when: "I enter a valid Administrator username and password and click login"
        username = "admin"
        password = "admin"
        $("button", type: "button").click()

        then: "I'm redirected to the Admin User Dashboard page"
        $("h1#HEADER_TITLE a").text() == "Administrator Dashboard"
    }
}