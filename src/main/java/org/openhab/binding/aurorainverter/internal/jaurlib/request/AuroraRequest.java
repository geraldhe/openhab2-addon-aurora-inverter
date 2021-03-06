/**
 * Copyright (c) 2010-2021 Contributors to the openHAB project
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.openhab.binding.aurorainverter.internal.jaurlib.request;

import org.openhab.binding.aurorainverter.internal.jaurlib.modbus.MbCode;
import org.openhab.binding.aurorainverter.internal.jaurlib.modbus.MbData;
import org.openhab.binding.aurorainverter.internal.jaurlib.modbus.MbPdu;
import org.openhab.binding.aurorainverter.internal.jaurlib.response.AuroraResponse;
import org.openhab.binding.aurorainverter.internal.jaurlib.response.AuroraResponseBuilder;

import javolution.io.Struct;

/**
 * @author Stefano Brega (22/11/14) - Initial contribution
 * @author Gerald Heilmann (08/06/18) - adaptations for using with OpenHAB
 */
public abstract class AuroraRequest extends MbPdu {

    public abstract AuroraResponse create(AuroraResponseBuilder builder);

    class MbDataInternal extends MbData {
        Unsigned8[] bytes = array(new Struct.Unsigned8[6]);
    }

    public AuroraRequest(MbCode code) {
        this.code = code;
        this.data = new MbDataInternal();
    }

    public void setParam1(char val) {
        ((MbDataInternal) data).bytes[0].set((short) val);
    }

    public short getParam1() {
        return ((MbDataInternal) data).bytes[0].get();
    }
}
