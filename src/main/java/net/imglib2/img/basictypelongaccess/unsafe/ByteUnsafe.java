package net.imglib2.img.basictypelongaccess.unsafe;

import net.imglib2.img.basictypelongaccess.ByteLongAccess;

public class ByteUnsafe implements ByteLongAccess
{

	private final long address;

	private final Object ownerReference;

	public ByteUnsafe( final long address )
	{
		this( address, null );
	}

	public ByteUnsafe( final long address, final Object ownerReference )
	{
		super();
		this.address = address;
		this.ownerReference = ownerReference;
	}

	@Override
	public byte getValue( final int index )
	{
		return getValue( ( long ) index );
	}

	@Override
	public void setValue( final int index, final byte value )
	{
		setValue( ( long ) index, value );
	}

	@Override
	public byte getValue( final long index )
	{
		return UnsafeUtil.UNSAFE.getByte( address + index );
	}

	@Override
	public void setValue( final long index, final byte value )
	{
		UnsafeUtil.UNSAFE.putByte( address + index, value );
	}

	public long getAddres()
	{
		return address;
	}

}
