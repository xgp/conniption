/**
 * Copyright 2013 Cameron Cook
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.celexus.conniption.foreman;

/**
 * An exception for the exclusive use of the conniption.foreman package
 *
 * @author cam
 *
 */
public class ForemanException extends Exception {

    public ForemanException(String message) {
        super(message);
    }

    public ForemanException(String message, Throwable e) {
        super(message, e);
    }

    private static final long serialVersionUID = 8119056765113019308L;

}
