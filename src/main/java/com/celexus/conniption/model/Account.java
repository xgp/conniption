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
package com.celexus.conniption.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.celexus.conniption.foreman.ForemanException;
import com.celexus.conniption.foreman.TKResponse;
import com.celexus.conniption.foreman.TradeKingForeman;
import com.celexus.conniption.foreman.util.ResponseFormat;
import com.celexus.conniption.foreman.util.UtilityException;
import com.celexus.conniption.foreman.util.XMLHandler;
import com.celexus.conniption.foreman.util.builder.AccountsBuilder;
import com.celexus.conniption.model.util.AccountsField;

/**
 * A representation of TradeKing Accounts
 *
 * @author cam
 *
 */
public class Account implements Serializable {

    private static final long serialVersionUID = -3038944208566900477L;
    private Map<AccountsField, String> map = new HashMap<AccountsField, String>();
    private TKResponse response;
    private String id;

    public Account(String id) throws ModelException {
        this.id = id;
        update();
    }

    public Account() throws ModelException {
        update();
    }

    public String getId() {
        return getField(AccountsField.ACCOUNT_NUMBER);
    }

    public Account(Map<AccountsField, String> fields) {
        map = fields;
    }

    public boolean hasField(AccountsField f) {
        return map.containsKey(f);
    }

    public String getField(AccountsField f) {
        return map.get(f);
    }

    public TKResponse getTKResponse() {
        return response;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (other instanceof Account) {
            Account otherA = (Account) other;
            for (AccountsField f : AccountsField.values()) {
                if (this.hasField(f) == otherA.hasField(f) && this.hasField(f)) {
                    this.getField(f).equals(otherA.getField(f));
                } else if (this.hasField(f) || otherA.hasField(f)) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    public void update() throws ModelException {
        TradeKingForeman foreman = new TradeKingForeman();
        if (id == null) {
            try {
                response = foreman.makeAPICall(AccountsBuilder.getAccounts(ResponseFormat.XML));
            } catch (ForemanException e) {
                throw new ModelException("Make API Call", e);
            }
        } else {
            try {
                response = foreman.makeAPICall(AccountsBuilder.getAccount(id, ResponseFormat.XML));
            } catch (ForemanException e) {
                throw new ModelException("Make API Call", e);
            }
        }
        map = parseAccount(response.toString());
    }

    public Map<AccountsField, String> parseAccount(String res) throws ModelException {
        XMLHandler handler = new XMLHandler();
        try {
            return handler.parseAccount(response.toString());
        } catch (UtilityException e) {
            throw new ModelException("", e);
        }
    }

}
