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
package org.openhab.binding.aurorainverter.internal.jaurlib.modbus;

/**
 * @author Stefano Brega (22/11/14) - Initial contribution
 * @author Gerald Heilmann (08/06/18) - adaptations for using with OpenHAB
 */
public abstract class MbAdu extends MbStruct {
    MbPdu pdu = null;
    MbCrc crc = null;

    MbPduFactory pduFactory = null;

    protected void checkCrc(MbCrc otherCrc) throws InvalidCrcException {
        if (computeCrc().getValue() != otherCrc.val.get()) {
            throw new InvalidCrcException("CRC Error");
        }
    }

    protected abstract MbCrc computeCrc();

    public MbPdu getPdu() {
        return pdu;
    }
}
