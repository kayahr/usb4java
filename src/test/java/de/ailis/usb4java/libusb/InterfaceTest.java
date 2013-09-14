/*
 * Copyright (C) 2013 Klaus Reimer <k@ailis.de>
 * See LICENSE.md for licensing information.
 */

package de.ailis.usb4java.libusb;

import static de.ailis.usb4java.test.UsbAssume.assumeUsbTestsEnabled;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests the {@link Interface} class.
 *
 * @author Klaus Reimer (k@ailis.de)
 */
public class InterfaceTest
{
    /** The test subject. */
    private Interface descriptor;

    /**
     * Setup test.
     */
    @Before
    public void setUp()
    {
        assumeUsbTestsEnabled();
        LibUsb.init(null);
        this.descriptor = new Interface();
    }

    /**
     * Tear down test.
     */
    @After
    public void tearDown()
    {
        LibUsb.exit(null);
    }

    /**
     * Tests uninitialized access to {@link Interface#altsetting()}
     */
    @Test(expected = IllegalStateException.class)
    public void testUninitializedAltsetting()
    {
        assumeUsbTestsEnabled();
        this.descriptor.altsetting();
    }

    /**
     * Tests uninitialized access to {@link Interface#numAltsetting()}
     */
    @Test(expected = IllegalStateException.class)
    public void testUninitializedDescriptorType()
    {
        assumeUsbTestsEnabled();
        this.descriptor.numAltsetting();
    }
}
