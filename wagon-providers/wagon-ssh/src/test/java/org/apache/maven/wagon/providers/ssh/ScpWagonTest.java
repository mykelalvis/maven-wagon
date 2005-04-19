package org.apache.maven.wagon.providers.ssh;

/*
 * Copyright 2001-2005 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.apache.maven.wagon.WagonTestCase;
import org.apache.maven.wagon.authentication.AuthenticationInfo;

import java.io.File;

/**
 * @author <a href="michal.maczka@dimatics.com">Michal Maczka</a>
 * @version $Id$
 */
public class ScpWagonTest
    extends WagonTestCase
{
    public ScpWagonTest( String testName )
    {
        super( testName );
    }

    protected String getProtocol()
    {
        return "scp";
    }

    public String getTestRepositoryUrl()
    {
        return TestData.getTestRepositoryUrl();
    }


    protected AuthenticationInfo getAuthInfo()
    {
        AuthenticationInfo authInfo = new AuthenticationInfo();

        String userName = TestData.getUserName();

        authInfo.setUserName( userName );

        File privateKey = TestData.getPrivateKey();

        if ( privateKey.exists() )
        {
            authInfo.setPrivateKey( privateKey.getAbsolutePath() );

            authInfo.setPassphrase( "" );
        }

        return authInfo;
    }

}