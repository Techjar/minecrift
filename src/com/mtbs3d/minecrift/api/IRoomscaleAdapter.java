package com.mtbs3d.minecrift.api;

import net.minecraft.util.Vec3;

/**
 * This interface defines convenience methods for getting 'world coordinate' vectors from room-scale VR systems.
 *
 * @author jrbudda
 *
 */
public interface IRoomscaleAdapter  {

    public boolean isHMDTracking();
	public Vec3 getHMDPos_World(); 
	public Vec3 getHMDDir_World(); 
	public float getHMDYaw_World();  //degrees
	public float getHMDPitch_World(); //degrees
	
    public boolean isControllerMainTracking();
	public Vec3 getControllerMainPos_World(); 
	public Vec3 getControllerMainDir_World(); 
	public float getControllerMainYaw_World(); //degrees
	public float getControllerMainPitch_World(); //degrees
	
    public boolean isControllerOffhandTracking();
	public Vec3 getControllerOffhandPos_World(); 
	public Vec3 getControllerOffhandDir_World(); 
	public float getControllerOffhandYaw_World(); //degrees
	public float getControllerOffhandPitch_World(); //degrees
	
	public Vec3 getRoomOriginPos_World(); //degrees
	public Vec3 getRoomOriginUpDir_World(); //what do you do
	
	public void triggerHapticPulse(int controller, int duration);
	
}

