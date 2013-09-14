/*
 * Copyright 2013 Luca Longinotti <l@longi.li>
 * See LICENSE.md for licensing information.
 *
 * Based on libusb <http://www.libusb.org/>:
 *
 * Copyright 2001 Johannes Erdfelt <johannes@erdfelt.com>
 * Copyright 2007-2009 Daniel Drake <dsd@gentoo.org>
 * Copyright 2010-2012 Peter Stuge <peter@stuge.se>
 * Copyright 2008-2011 Nathan Hjelm <hjelmn@users.sourceforge.net>
 * Copyright 2009-2012 Pete Batard <pete@akeo.ie>
 * Copyright 2009-2012 Ludovic Rousseau <ludovic.rousseau@gmail.com>
 * Copyright 2010-2012 Michael Plante <michael.plante@gmail.com>
 * Copyright 2011-2012 Hans de Goede <hdegoede@redhat.com>
 * Copyright 2012 Martin Pieuchot <mpi@openbsd.org>
 * Copyright 2012-2013 Toby Gray <toby.gray@realvnc.com>
 */

package de.ailis.usb4java.libusb;

public final class IsoPacketDescriptor
{
    /** The native pointer to the descriptor structure. */
    private long isoPacketDescriptorPointer;

    /**
     * Package-private constructor to prevent manual instantiation.
     * IsoPacketDescriptors are always created by JNI.
     */
    IsoPacketDescriptor()
    {
        // Empty
    }

    /**
     * Returns the native pointer.
     *
     * @return The native pointer.
     */
    public long getPointer()
    {
        return this.isoPacketDescriptorPointer;
    }

    public native int length();

    // Theoretically the right representation for a C unsigned int would be a
    // Java long, but the maximum length for ISO Packets is 1024 bytes, so an
    // int more than suffices to hold any possible valid values here.
    public native void setLength(final int length);

    public native int actualLength();

    public native int status();

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = (prime * result)
            + (int) (this.isoPacketDescriptorPointer ^ (this.isoPacketDescriptorPointer >>> 32));
        return result;
    }

    @Override
    public boolean equals(final Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (this.getClass() != obj.getClass())
        {
            return false;
        }
        final IsoPacketDescriptor other = (IsoPacketDescriptor) obj;
        if (this.isoPacketDescriptorPointer != other.isoPacketDescriptorPointer)
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return String.format("libusb iso packet descriptor 0x%x",
            this.isoPacketDescriptorPointer);
    }
}
