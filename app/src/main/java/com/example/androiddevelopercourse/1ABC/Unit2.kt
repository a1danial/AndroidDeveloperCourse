package com.example.androiddevelopercourse

open class SmartDevice(val name: String, val category: String) {

    var deviceStatus = "online"

    open val deviceType = "unknown"

    constructor(name: String, category: String, statusCode: Int) : this(name, category) {
        deviceStatus = when (statusCode) {
            0 -> "offline"
            1 -> "online"
            else -> "unknown"
        }
    }

    open fun turnOn() {
        deviceStatus = "on"
        println("Smart device is turned on")
    }
    open fun turnOff() {
        deviceStatus = "off"
        println("Smart device is turned off")
    }
}

class SmartTvDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {

    override val deviceType = "Smart TV"

    var speakerVolume = 2
        set(value) {
            if (value in 0..100) {
                field = value
            }
        }
    var channelNumber = 1
        set(value) {
            if (value in 0..200) {
                field = value
            }
        }

    override fun turnOn() {
        // Original code
//        deviceStatus = "on"
//        println(
//            "$name is turned on. Speaker volume is set to $speakerVolume and channel number is " +
//                    "set to $channelNumber."
//        )

        // Super to call method from SmartDevice
        super.turnOn()
        println("Smart TV turned on. Speaker volume set to $speakerVolume.")
    }

    override fun turnOff() {
        // Original code
//        deviceStatus = "off"
//        println("$name turned off")

        // Super to call method from SmartDevice
        super.turnOff()
        println("Speaker volume increased to $speakerVolume.")
    }

    fun increaseSpeakerVolume() {
        speakerVolume++
        println("Speaker volume increased to $speakerVolume.")
    }

    fun nextChannel() {
        channelNumber++
        println("Channel number increased to $speakerVolume.")
    }
}

class SmartLightDevice(deviceName: String, deviceCategory: String) :
        SmartDevice(name = deviceName, category = deviceCategory) {

    override val deviceType = "Smart Light"

    var brightnessLevel = 0
        set(value) {
            if (value in 0..100) {
                field = value
            }
        }

    override fun turnOn() {
        super.turnOn()
//        deviceStatus = "on"
        brightnessLevel = 2
        println("$name turned on. The brightness level is $brightnessLevel.")
    }

    override fun turnOff() {
        super.turnOff()
//        deviceStatus = "off"
        brightnessLevel = 0
        println("Smart Light turned off")
    }

    fun increaseBrightness() {
        brightnessLevel++
        println("Brightness increased to $brightnessLevel.")
    }

}

class SmartHome (val smartTvDevice: SmartTvDevice, val smartLightDevice: SmartLightDevice) {

    fun turnOnTV() {
        smartTvDevice.turnOn()
    }

    fun turnOffTV() {
        smartTvDevice.turnOff()
    }

    fun increaseTvVolume() {
        smartTvDevice.increaseSpeakerVolume()
    }

    fun changeTvChannelToNext() {
        smartTvDevice.nextChannel()
    }

    fun turnOnLight() {
        smartLightDevice.turnOn()
    }

    fun turnOffLight() {
        smartLightDevice.turnOff()
    }

    fun increaseLightBrightness() {
        smartLightDevice.increaseBrightness()
    }

    fun turnOffAllDevices() {
        turnOffTV()
        turnOffLight()
    }

}

fun main(){
    var smartDevice: SmartDevice = SmartTvDevice("Android TV", "Entertainment")
    smartDevice.turnOn()

    smartDevice = SmartLightDevice("Google Light", "Utility")
    smartDevice.turnOn()
}

