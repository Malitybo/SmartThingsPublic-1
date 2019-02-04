/**
 *  HeatIt Z-wave Scene Controller
 *  Copyright 2018 Ivar Sandstad
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License. You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 *  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the specific language governing permissions and limitations under the License.
 *
 */
metadata {
	definition (name: "HeatIt Z-wave Scene Controller", namespace: "ivarsand", author: "Ivar Sandstad") {
        capability "Actuator"
        capability "Button"
        capability "Configuration"
        capability "Holdable Button"
        capability "Indicator"
        capability "Switch"
        capability "Sensor"
        capability "Health Check"

        attribute "sequenceNumber", "number"
        attribute "numberOfButtons", "number"

        fingerprint mfr: "0234", prod: "0003", model: "010C"

		//fingerprint deviceId: "0x010C", inClusters: "0x5E,0x86,0x72,0x5A,0x73,0x7A,0x85,0x59,0x8E,0x70,0x60,0x25,0x28,0x26,0x5B,0x87"
	}

	simulator {
		status "button 1 pushed":  "command: 5B03, payload: 2B 00 01"
		status "button 1 held":  "command: 5B03, payload: 2B 02 01"
        status "button 1 released":  "command: 5B03, payload: 2C 01 01"
        status "button 1 double":  "command: 5B03, payload: 2F 03 01"
		status "button 2 pushed":  "command: 5B03, payload: 23 00 02"
		status "button 2 held":  "command: 5B03, payload: 2B 02 02"
        status "button 2 released":  "command: 5B03, payload: 2C 01 02"
        status "button 2 double":  "command: 5B03, payload: 2F 03 02"
		status "button 3 pushed":  "command: 5B03, payload: 23 00 03"
		status "button 3 held":  "command: 5B03, payload: 2B 02 03"
        status "button 3 released":  "command: 5B03, payload: 2C 01 03"
        status "button 3 double":  "command: 5B03, payload: 2F 03 03"
		status "button 4 pushed":  "command: 5B03, payload: 23 00 04"
		status "button 4 held":  "command: 5B03, payload: 2B 02 04"
        status "button 4 released":  "command: 5B03, payload: 2C 01 04"
        status "button 4 double":  "command: 5B03, payload: 2F 03 04"
        status "button 5 pushed":  "command: 5B03, payload: 23 00 05"
		status "button 5 held":  "command: 5B03, payload: 2B 02 05"
        status "button 5 released":  "command: 5B03, payload: 2C 01 05"
        status "button 5 double":  "command: 5B03, payload: 2F 03 05"
		status "button 6 pushed":  "command: 5B03, payload: 23 00 06"
		status "button 6 held":  "command: 5B03, payload: 2B 02 06"
        status "button 6 released":  "command: 5B03, payload: 2C 01 06"
        status "button 6 double":  "command: 5B03, payload: 2F 03 06"
	}
	tiles (scale: 2) {
		multiAttributeTile(name:"button", type:"generic", width:6, height:4) {
  			tileAttribute("device.button", key: "PRIMARY_CONTROL"){
    		attributeState "default", label:'', backgroundColor:"#ffffff", icon: "st.unknown.zwave.remote-controller"
  			}
            tileAttribute ("device.battery", key: "SECONDARY_CONTROL") {
			attributeState "battery", label:'${currentValue} % battery'
            }

        }

		standardTile("B1", "device.button", width: 2, height: 2, decoration: "flat") {
			state "default", label: 'Button 1', icon: "st.unknown.zwave.remote-controller"
		}
		standardTile("B1.push", "device.button", width: 2, height: 2, decoration: "flat") {
			state "default", label: 'Push', action: "ButtonEvent(1)"
		}
		standardTile("B1.hold", "device.button", width: 2, height: 2, decoration: "flat") {
			state "default", label: 'Hold', action: "ButtonEvent(2)"
		}
		standardTile("B2", "device.button", width: 2, height: 2, decoration: "flat") {
			state "default", label: 'Button 2', icon: "st.unknown.zwave.remote-controller"
		}
		standardTile("B2.push", "device.button", width: 2, height: 2, decoration: "flat") {
			state "default", label: 'Push', action: "ButtonEvent(3)"
		}
		standardTile("B2.hold", "device.button", width: 2, height: 2, decoration: "flat") {
			state "default", label: 'Hold', action: "ButtonEvent(4)"
		}

		standardTile("B3", "device.button", width: 2, height: 2, decoration: "flat") {
			state "default", label: 'Button 3', icon: "st.unknown.zwave.remote-controller"
		}
		standardTile("B3.push", "device.button", width: 2, height: 2, decoration: "flat") {
			state "default", label: 'Push', action: "ButtonEvent(5)"
		}
		standardTile("B3.hold", "device.button", width: 2, height: 2, decoration: "flat") {
			state "default", label: 'Hold', action: "ButtonEvent(6)"
		}
		standardTile("B4", "device.button", width: 2, height: 2, decoration: "flat") {
			state "default", label: 'Button 4', icon: "st.unknown.zwave.remote-controller"
		}
		standardTile("B4.push", "device.button", width: 2, height: 2, decoration: "flat") {
			state "default", label: 'Push', action: "ButtonEvent(7)"
		}
		standardTile("B4.hold", "device.button", width: 2, height: 2, decoration: "flat") {
			state "default", label: 'Hold', action: "ButtonEvent(8)"
		}
		standardTile("B5", "device.button", width: 2, height: 2, decoration: "flat") {
			state "default", label: 'Button 5', icon: "st.unknown.zwave.remote-controller"
		}
		standardTile("B5.push", "device.button", width: 2, height: 2, decoration: "flat") {
			state "default", label: 'Push', action: "ButtonEvent(9)"
		}
		standardTile("B5.hold", "device.button", width: 2, height: 2, decoration: "flat") {
			state "default", label: 'Hold', action: "ButtonEvent(10)"
		}
		standardTile("B6", "device.button", width: 2, height: 2, decoration: "flat") {
			state "default", label: 'Button 6', icon: "st.unknown.zwave.remote-controller"
		}
		standardTile("B6.push", "device.button", width: 2, height: 2, decoration: "flat") {
			state "default", label: 'Push', action: "ButtonEvent(11)"
		}
		standardTile("B6.hold", "device.button", width: 2, height: 2, decoration: "flat") {
			state "default", label: 'Hold', action: "ButtonEvent(12)"
		}
		
standardTile("configure", "device.configure", inactiveLabel: false, width: 1, height: 1, decoration: "flat") {
			state "configure", label:'', action:"configuration.configure", icon:"st.secondary.configure"
		}
		main "button"
		details(["button", "B1", "B1.push",  "B1.hold", "B2", "B2.push",  "B2.hold", "configure"])
	}

    preferences {

        section { // GENERAL:
            input (
                type: "paragraph",
                element: "paragraph",
                title: "GENERAL:",
                description: "General device handler settings."
            )

            input (
                name: "configLoggingLevelIDE",
                title: "IDE Live Logging Level: Messages with this level and higher will be logged to the IDE.",
                type: "enum",
                options: [
                    "0" : "None",
                    "1" : "Error",
                    "2" : "Warning",
                    "3" : "Info",
                    "4" : "Debug",
                    "5" : "Trace"
                ],
                defaultValue: "3", // iPhone users can uncomment these lines!
                required: true
            )

            input (
                name: "configLoggingLevelDevice",
                title: "Device Logging Level: Messages with this level and higher will be logged to the logMessage attribute.",
                type: "enum",
                options: [
                    "0" : "None",
                    "1" : "Error",
                    "2" : "Warning"
                ],
                defaultValue: "2", // iPhone users can uncomment these lines!
                required: true
            )
		}
/*

        section { // BUTTON MODE:
            input (
                type: "paragraph",
                element: "paragraph",
                title: "BUTTON and LED mode:",
                description: "Setting for separate or pair buttons."
            )

            input (
                name: "upperPaddleButtonsMode",
                title: "Separate or pair buttons first row.",
                type: "enum",
                options: [
                    "0" : "Separate (togglemode)",
                    "1" : "Pair mode. Left On/Up Right Off/Down"
                ],
                defaultValue: "0", // iPhone users can uncomment these lines!
                required: true
            )
            input (
                name: "middlePaddleButtonsMode",
                title: "Separate or pair buttons middle row.",
                type: "enum",
                options: [
                    "0" : "Separate (togglemode)",
                    "1" : "Pair mode. Left On/Up Right Off/Down"
                ],
                defaultValue: "0", // iPhone users can uncomment these lines!
                required: true
            )
			input (
                name: "lowerPaddleButtonsMode",
                title: "Separate or pair buttons lower row.",
                type: "enum",
                options: [
                    "0" : "Separate (togglemode)",
                    "1" : "Pair mode. Left On/Up Right Off/Down"
                ],
                defaultValue: "0", // iPhone users can uncomment these lines!
                required: true
            )

            input (
                name: "LED1operation",
                title: "Configuration of the internal operation of LED #1.",
                type: "enum",
                options: [
                    "0" : "LED indication is disabled (LED can be controlled by Indicator Command Class Set commands)",
                    "1" : "LED indicates the status of the corresponding button. (Default)",
                    "2" : "LED indicates the status of the corresponding button, with inverted indication",
                    "3" : "LED indicates the status of corresponding paddle (in pair mode)",
                    "4" : "LED indicates the status of the corresponding paddle (inpair mode), with inverted indication",
                    "5" : "LED indicates the status of the built-in relay",
                    "6" : "LED indicates the status of the built-in relay, with inverted indication",
                    "7" : "LED show a 5 seconds indication when the corresponding button is pressed"
                ],
                defaultValue: "1", // iPhone users can uncomment these lines!
                required: true
            )
            input (
                name: "LED2operation",
                title: "Configuration of the internal operation of LED #2.",
                type: "enum",
                options: [
                    "0" : "LED indication is disabled (LED can be controlled by Indicator Command Class Set commands)",
                    "1" : "LED indicates the status of the corresponding button. (Default)",
                    "2" : "LED indicates the status of the corresponding button, with inverted indication",
                    "3" : "LED indicates the status of corresponding paddle (in pair mode)",
                    "4" : "LED indicates the status of the corresponding paddle (inpair mode), with inverted indication",
                    "5" : "LED indicates the status of the built-in relay",
                    "6" : "LED indicates the status of the built-in relay, with inverted indication",
                    "7" : "LED show a 5 seconds indication when the corresponding button is pressed"
                ],
                defaultValue: "1", // iPhone users can uncomment these lines!
                required: true
            )
            input (
                name: "LED3operation",
                title: "Configuration of the internal operation of LED #3.",
                type: "enum",
                options: [
                    "0" : "LED indication is disabled (LED can be controlled by Indicator Command Class Set commands)",
                    "1" : "LED indicates the status of the corresponding button. (Default)",
                    "2" : "LED indicates the status of the corresponding button, with inverted indication",
                    "3" : "LED indicates the status of corresponding paddle (in pair mode)",
                    "4" : "LED indicates the status of the corresponding paddle (inpair mode), with inverted indication",
                    "5" : "LED indicates the status of the built-in relay",
                    "6" : "LED indicates the status of the built-in relay, with inverted indication",
                    "7" : "LED show a 5 seconds indication when the corresponding button is pressed"
                ],
                defaultValue: "1", // iPhone users can uncomment these lines!
                required: true
            )
            input (
                name: "LED4operation",
                title: "Configuration of the internal operation of LED #4.",
                type: "enum",
                options: [
                    "0" : "LED indication is disabled (LED can be controlled by Indicator Command Class Set commands)",
                    "1" : "LED indicates the status of the corresponding button. (Default)",
                    "2" : "LED indicates the status of the corresponding button, with inverted indication",
                    "3" : "LED indicates the status of corresponding paddle (in pair mode)",
                    "4" : "LED indicates the status of the corresponding paddle (inpair mode), with inverted indication",
                    "5" : "LED indicates the status of the built-in relay",
                    "6" : "LED indicates the status of the built-in relay, with inverted indication",
                    "7" : "LED show a 5 seconds indication when the corresponding button is pressed"
                ],
                defaultValue: "1", // iPhone users can uncomment these lines!
                required: true
            )
            input (
                name: "LED5operation",
                title: "Configuration of the internal operation of LED #5.",
                type: "enum",
                options: [
                    "0" : "LED indication is disabled (LED can be controlled by Indicator Command Class Set commands)",
                    "1" : "LED indicates the status of the corresponding button. (Default)",
                    "2" : "LED indicates the status of the corresponding button, with inverted indication",
                    "3" : "LED indicates the status of corresponding paddle (in pair mode)",
                    "4" : "LED indicates the status of the corresponding paddle (inpair mode), with inverted indication",
                    "5" : "LED indicates the status of the built-in relay",
                    "6" : "LED indicates the status of the built-in relay, with inverted indication",
                    "7" : "LED show a 5 seconds indication when the corresponding button is pressed"
                ],
                defaultValue: "1", // iPhone users can uncomment these lines!
                required: true
            )
            input (
                name: "LED6operation",
                title: "Configuration of the internal operation of LED #6.",
                type: "enum",
                options: [
                    "0" : "LED indication is disabled (LED can be controlled by Indicator Command Class Set commands)",
                    "1" : "LED indicates the status of the corresponding button. (Default)",
                    "2" : "LED indicates the status of the corresponding button, with inverted indication",
                    "3" : "LED indicates the status of corresponding paddle (in pair mode)",
                    "4" : "LED indicates the status of the corresponding paddle (inpair mode), with inverted indication",
                    "5" : "LED indicates the status of the built-in relay",
                    "6" : "LED indicates the status of the built-in relay, with inverted indication",
                    "7" : "LED show a 5 seconds indication when the corresponding button is pressed"
                ],
                defaultValue: "1", // iPhone users can uncomment these lines!
                required: true
            )
		}
        section { // RELAY SCENE AND CLEANING:
            input (
                type: "paragraph",
                element: "paragraph",
                title: "Relay, Scene and Cleaning (100% light) mode:",
                description: "Setting for separate or pair buttons."
            )
            input (
                name: "relayMode",
                title: "Relay Mode configures which of the buttons that shall control the built-in relay",
                type: "enum",
                options: [
                    "0" : "Relay is disabled",
                    "1" : "Relay is controlled by button #1 or by upper paddle when pair mode is active. (Default)",
                    "2" : "Relay is controlled by button #2 or by upper paddle when pair mode is active",
                    "3" : "Relay is controlled by button #3 or by middle paddle when pair mode is active",
                    "4" : "Relay is controlled by button #4 or by middle paddle when pair mode is active",
                    "5" : "Relay is controlled by button #5 or by lower paddle when pair mode is active",
                    "6" : "Relay is controlled by button #6 or by lower paddle when pair mode is active",
                    "7" : "Relay is activated for one second and is controlled by button #1 or by upper paddle when pair mode is active"
                ],
                defaultValue: "1", // iPhone users can uncomment these lines!
                required: true
            )
            input (
                name: "disableCentralScene",
                title: "Disables or enables the sending of Central Scene notifications",
                type: "enum",
                options: [
                    "0" : "Central Scene notifications are enabled. (Default)",
                    "1" : "Central Scene notifications are disabled"
                ],
                defaultValue: "0", // iPhone users can uncomment these lines!
                required: true
            )
            input (
                name: "disableHouseCleaning",
                title: "Disable or enables that a double-press on a button will send a command to activate 100% light.",
                type: "enum",
                options: [
                    "0" : "House Cleaning Mode is enabled (Default)",
                    "1" : "House Cleaning Mode is disabled; double-press button scene notifications will be disabled too"
                ],
                defaultValue: "0", // iPhone users can uncomment these lines!
                required: true
            )
        }
  */
  /*
        section { // PROTECTION:
            input type: "paragraph",
                element: "paragraph",
                title: "PROTECTION:",
                description: "Prevent unintentional control (e.g. by a child) by disabling the physical switches and/or RF control."

            input (
                name: "configProtectLocal",
                title: "Local Protection: Applies to physical switches:",
                type: "enum",
                options: [
                    "0" : "Unprotected",
                    //"1" : "Protection by sequence", // Not supported by Fibaro Dimmer 2.
                    "2" : "No operation possible"
                ],
//                defaultValue: "0", // iPhone users can uncomment these lines!
                required: true
            )

            input (
                name: "configProtectRF",
                title: "RF Protection: Applies to Z-Wave commands sent from hub or other devices:",
                type: "enum",
                options: [
                    "0" : "Unprotected",
                    "1" : "No RF control"//,
                    //"2" : "No RF response" // Not supported by Fibaro Dimmer 2.
                ],
//                defaultValue: "0", // iPhone users can uncomment these lines!
                required: true
            )

        }
*/

        generatePrefsParams()

        generatePrefsAssocGroups()

    }
}

def parse(String description) {
	def results = []
     logging("${description}")
	if (description.startsWith("Err")) {
	    results = createEvent(descriptionText:description, displayed:true)
	} else {
		def cmd = zwave.parse(description, [0x2B: 1, 0x80: 1, 0x84: 1])
		if(cmd) results += zwaveEvent(cmd)
		if(!results) results = [ descriptionText: cmd, displayed: false ]
	}

    if(state.isConfigured != "true") configure()

	return results
}

def zwaveEvent(physicalgraph.zwave.commands.centralscenev1.CentralSceneNotification cmd) {
        logging(cmd)
        logging("keyAttributes: $cmd.keyAttributes")
        logging("sceneNumber: $cmd.sceneNumber")
        logging("sequenceNumber: $cmd.sequenceNumber")

        sendEvent(name: "sequenceNumber", value: cmd.sequenceNumber, displayed:false)
        switch (cmd.keyAttributes) {
           case 0:
              buttonEvent(cmd.sceneNumber, "pushed")
           break
           case 1:
              if (settings.holdMode == "2") buttonEvent(cmd.sceneNumber, "held")
           break
           case 2:
              if (!settings.holdMode || settings.holdMode == "1") buttonEvent(cmd.sceneNumber, "held")
           break
           case 3:
              buttonEvent(cmd.sceneNumber + 8, "pushed")
           break
           default:
               logging("Unhandled CentralSceneNotification: ${cmd}")
           break
        }
}

private def logging(message) {
    if (settings.debug == "true") log.debug "$message"
}


def zwaveEvent(physicalgraph.zwave.commands.wakeupv1.WakeUpNotification cmd) {
	def results = [createEvent(descriptionText: "$device.displayName woke up", isStateChange: false)]
	results << response(zwave.wakeUpV1.wakeUpNoMoreInformation().format())
	return results
}

def buttonEvent(button, value) {
	createEvent(name: "button", value: value, data: [buttonNumber: button], descriptionText: "$device.displayName button $button was $value", isStateChange: true)
}

def zwaveEvent(physicalgraph.zwave.commands.batteryv1.BatteryReport cmd) {
	def map = [ name: "battery", unit: "%" ]
	if (cmd.batteryLevel == 0xFF) {
		map.value = 1
		map.descriptionText = "${device.displayName} battery is low"
		map.isStateChange = true
	} else {
		map.value = cmd.batteryLevel
	}
	createEvent(map)
}

def zwaveEvent(physicalgraph.zwave.Command cmd) {
	logging("Unhandled zwaveEvent: ${cmd}")
}

def installed() {
    logging("installed()")
    configure()
}

def updated() {
    logging("updated()")
    configure()
}

def configure() {
	logging("configure()")

        // Update Parameter target values:
        getParamsMd().findAll( {!it.readonly} ).each { // Exclude readonly parameters.
            state."paramTarget${it.id}" = settings."configParam${it.id}"?.toInteger()
        }

        // Update Assoc Group target values:
        state.assocGroupTarget1 = [ zwaveHubNodeId ] // Assoc Group #1 is Lifeline and will contain controller only.
        getAssocGroupsMd().findAll( { it.id != 1} ).each {
            state."assocGroupTarget${it.id}" = parseAssocGroupInput(settings."configAssocGroup${it.id}", it.maxNodes)
        }

    sendEvent(name: "checkInterval", value: 2 * 60 * 12 * 60 + 5 * 60, displayed: false, data: [protocol: "zwave", hubHardwareId: device.hub.hardwareID])
    sendEvent(name: "numberOfButtons", value: 12, displayed: true)
    state.isConfigured = "true"
}

def ping() {
    logging("ping()")
	logging("Is ping necessary?")
}


/**
 *  generatePrefsParams()
 *
 *  Generates preferences (settings) for device parameters.
 **/
private generatePrefsParams() {
        section {
            input (
                type: "paragraph",
                element: "paragraph",
                title: "DEVICE PARAMETERS:",
                description: "Device parameters are used to customise the physical device. " +
                             "Refer to the product documentation for a full description of each parameter."
            )

    getParamsMd().findAll( {!it.readonly} ).each { // Exclude readonly parameters.

        def lb = (it.description.length() > 0) ? "\n" : ""

        switch(it.type) {
            case "number":
            input (
                name: "configParam${it.id}",
                title: "#${it.id}: ${it.name}: \n" + it.description + lb +"Default Value: ${it.defaultValue}",
                type: it.type,
                range: it.range,
//                defaultValue: it.defaultValue, // iPhone users can uncomment these lines!
                required: it.required
            )
            break

            case "enum":
            input (
                name: "configParam${it.id}",
                title: "#${it.id}: ${it.name}: \n" + it.description + lb + "Default Value: ${it.defaultValue}",
                type: it.type,
                options: it.options,
//                defaultValue: it.defaultValue, // iPhone users can uncomment these lines!
                required: it.required
            )
            break
        }
    }
        } // section
}

/**
 *  generatePrefsAssocGroups()
 *
 *  Generates preferences (settings) for Association Groups.
 **/
private generatePrefsAssocGroups() {
        section {
            input (
                type: "paragraph",
                element: "paragraph",
                title: "ASSOCIATION GROUPS:",
                description: "Association groups enable the dimmer to control other Z-Wave devices directly, " +
                             "without participation of the main controller.\n" +
                             "Enter a comma-delimited list of destinations (node IDs and/or endpoint IDs) for " +
                             "each association group. All IDs must be in hexadecimal format. E.g.:\n" +
                             "Node destinations: '11, 0F'\n" +
                             "Endpoint destinations: '1C:1, 1C:2'"
            )

    getAssocGroupsMd().findAll( { it.id != 1} ).each { // Don't show AssocGroup1 (Lifeline).
            input (
                name: "configAssocGroup${it.id}",
                title: "Association Group #${it.id}: ${it.name}: \n" + it.description + " \n[MAX NODES: ${it.maxNodes}]",
                type: "text",
//                defaultValue: "", // iPhone users can uncomment these lines!
                required: false
            )
        }
    }
}

/**
 *  logger()
 *
 *  Wrapper function for all logging:
 *    Logs messages to the IDE (Live Logging), and also keeps a historical log of critical error and warning
 *    messages by sending events for the device's logMessage attribute.
 *    Configured using configLoggingLevelIDE and configLoggingLevelDevice preferences.
 **/
private logger(msg, level = "debug") {

    switch(level) {
        case "error":
            if (state.loggingLevelIDE >= 1) log.error msg
            if (state.loggingLevelDevice >= 1) sendEvent(name: "logMessage", value: "ERROR: ${msg}", displayed: false, isStateChange: true)
            break

        case "warn":
            if (state.loggingLevelIDE >= 2) log.warn msg
            if (state.loggingLevelDevice >= 2) sendEvent(name: "logMessage", value: "WARNING: ${msg}", displayed: false, isStateChange: true)
            break

        case "info":
            if (state.loggingLevelIDE >= 3) log.info msg
            break

        case "debug":
            if (state.loggingLevelIDE >= 4) log.debug msg
            break

        case "trace":
            if (state.loggingLevelIDE >= 5) log.trace msg
            break

        default:
            log.debug msg
            break
    }
}

/*****************************************************************************************************************
 *  Static Matadata Functions:
 *
 *  These functions encapsulate metadata about the device. Mostly obtained from:
 *   Z-wave Alliance Reference for Fibaro Dimmer 2: http://products.z-wavealliance.org/products/1729
 *****************************************************************************************************************/

/**
 *  getCommandClassVersions()
 *
 *  Returns a map of the command class versions supported by the device. Used by parse() and zwaveEvent() to
 *  extract encapsulated commands from MultiChannelCmdEncap, MultiInstanceCmdEncap, SecurityMessageEncapsulation,
 *  and Crc16Encap messages.
 *
 *  Reference: http://products.z-wavealliance.org/products/1729/classes
 **/
private getCommandClassVersions() {
    return [0x20: 1, // Basic V1
            0x22: 1, // Application Status V1
            0x26: 3, // Switch Multilevel V3
            // xx 0x27: 1, // Switch All V1
            0x28: 1, // Switch Toggle Binary
/*            0x2B: 1, // Scene Activation V1
            0x31: 4, // Sensor Multilevel V4
            0x32: 3, // Meter V3
            0x56: 1, // CRC16 Encapsulation V1
*/
            0x59: 1, // Association Group Information V1
            0x5A: 1, // Device Reset Locally V1
            0x5B: 1, // Central Scene
            //0x5E: 2, // Z-Wave Plus Info V2 (Not supported by SmartThings)
            0x60: 3, // Multi Channel V4 (Device supports V4, but SmartThings only supports V3)
            0x70: 1, // Configuration V1
            // xx 0x71: 3, // Notification V5 ((Device supports V5, but SmartThings only supports V3)
            0x72: 2, // Manufacturer Specific V2
            0x73: 1, // Powerlevel V1
            // xx 0x75: 2, // Protection V2
            0x7A: 2, // Firmware Update MD V3 (Device supports V3, but SmartThings only supports V2)
            0x85: 2, // Association V2
            0x86: 1, // Version V2 (Device supports V2, but SmartThings only supports V1)
            0x8E: 2, // Multi Channel Association V3 (Device supports V3, but SmartThings only supports V2)
            // xx 0x98: 1  // Security V1
           ]
}

/**
 *  getParamsMd()
 *
 *  Returns device parameters metadata. Used by sync(), updateSyncPending(),  and generatePrefsParams().
 *
 *  Reference: http://products.z-wavealliance.org/products/1729/configs
 **/
private getParamsMd() {
    return [
        [id: 1, size: 1, type: "enum", defaultValue: "0", required: false, readonly: false,
         name: "Upper paddle buttons mode",
         description : "Configuration of Pair Mode for the upper two buttons (button #1 and #2)",
         options: ["0" : "0: Separate mode (toggle mode). (Default)",
                   "1" : "1: In pair mode, left side sends on/up commands, right side sends off/down commands"]],
        [id: 2, size: 1, type: "enum", defaultValue: "0", required: false, readonly: false,
         name: "Middle paddle buttons mode",
         description : "Configuration of Pair Mode for the upper two buttons (button #3 and #4)",
         options: ["0" : "0: Separate mode (toggle mode). (Default)",
                   "1" : "1: In pair mode, left side sends on/up commands, right side sends off/down commands"]],
        [id: 3, size: 1, type: "enum", defaultValue: "0", required: false, readonly: false,
         name: "Lower paddle buttons mode",
         description : "Configuration of Pair Mode for the upper two buttons (button #5 and #6)",
         options: ["0" : "0: Separate mode (toggle mode). (Default)",
                   "1" : "1: In pair mode, left side sends on/up commands, right side sends off/down commands"]],

        [id: 4, size: 1, type: "enum", defaultValue: "1", required: false, readonly: false,
         name: "LED #1 mode",
         description : "Configuration of the internal operation of LED #1",
		 options: ["0" : "0: LED indication is disabled (LED can be controlled by Indicator Command Class Set commands)",
		           "1" : "1: LED indicates the status of the corresponding button. (Default)",
		           "2" : "2: LED indicates the status of the corresponding button, with inverted indication",
		           "3" : "3: LED indicates the status of corresponding paddle (in pair mode)",
		           "4" : "4: LED indicates the status of the corresponding paddle (in pair mode), with inverted indication",
		           "5" : "5: LED indicates the status of the built-in relay",
		           "6" : "6: LED indicates the status of the built-in relay, with inverted indication",
		           "7" : "7: LED show a 5 seconds indication when the corresponding button is pressed"]],
        [id: 5, size: 1, type: "enum", defaultValue: "1", required: false, readonly: false,
         name: "LED #2 mode",
         description : "Configuration of the internal operation of LED #2",
		 options: ["0" : "0: LED indication is disabled (LED can be controlled by Indicator Command Class Set commands)",
		           "1" : "1: LED indicates the status of the corresponding button. (Default)",
		           "2" : "2: LED indicates the status of the corresponding button, with inverted indication",
		           "3" : "3: LED indicates the status of corresponding paddle (in pair mode)",
		           "4" : "4: LED indicates the status of the corresponding paddle (in pair mode), with inverted indication",
		           "5" : "5: LED indicates the status of the built-in relay",
		           "6" : "6: LED indicates the status of the built-in relay, with inverted indication",
		           "7" : "7: LED show a 5 seconds indication when the corresponding button is pressed"]],
        [id: 6, size: 1, type: "enum", defaultValue: "1", required: false, readonly: false,
         name: "LED #3 mode",
         description : "Configuration of the internal operation of LED #3",
		 options: ["0" : "0: LED indication is disabled (LED can be controlled by Indicator Command Class Set commands)",
		           "1" : "1: LED indicates the status of the corresponding button. (Default)",
		           "2" : "2: LED indicates the status of the corresponding button, with inverted indication",
		           "3" : "3: LED indicates the status of corresponding paddle (in pair mode)",
		           "4" : "4: LED indicates the status of the corresponding paddle (in pair mode), with inverted indication",
		           "5" : "5: LED indicates the status of the built-in relay",
		           "6" : "6: LED indicates the status of the built-in relay, with inverted indication",
		           "7" : "7: LED show a 5 seconds indication when the corresponding button is pressed"]],
        [id: 7, size: 1, type: "enum", defaultValue: "1", required: false, readonly: false,
         name: "LED #4 mode",
         description : "Configuration of the internal operation of LED #4",
		 options: ["0" : "0: LED indication is disabled (LED can be controlled by Indicator Command Class Set commands)",
		           "1" : "1: LED indicates the status of the corresponding button. (Default)",
		           "2" : "2: LED indicates the status of the corresponding button, with inverted indication",
		           "3" : "3: LED indicates the status of corresponding paddle (in pair mode)",
		           "4" : "4: LED indicates the status of the corresponding paddle (in pair mode), with inverted indication",
		           "5" : "5: LED indicates the status of the built-in relay",
		           "6" : "6: LED indicates the status of the built-in relay, with inverted indication",
		           "7" : "7: LED show a 5 seconds indication when the corresponding button is pressed"]],
        [id: 8, size: 1, type: "enum", defaultValue: "1", required: false, readonly: false,
         name: "LED #5 mode",
         description : "Configuration of the internal operation of LED #5",
		 options: ["0" : "0: LED indication is disabled (LED can be controlled by Indicator Command Class Set commands)",
		           "1" : "1: LED indicates the status of the corresponding button. (Default)",
		           "2" : "2: LED indicates the status of the corresponding button, with inverted indication",
		           "3" : "3: LED indicates the status of corresponding paddle (in pair mode)",
		           "4" : "4: LED indicates the status of the corresponding paddle (in pair mode), with inverted indication",
		           "5" : "5: LED indicates the status of the built-in relay",
		           "6" : "6: LED indicates the status of the built-in relay, with inverted indication",
		           "7" : "7: LED show a 5 seconds indication when the corresponding button is pressed"]],
        [id: 9, size: 1, type: "enum", defaultValue: "1", required: false, readonly: false,
         name: "LED #6 mode",
         description : "Configuration of the internal operation of LED #6",
		 options: ["0" : "0: LED indication is disabled (LED can be controlled by Indicator Command Class Set commands)",
		           "1" : "1: LED indicates the status of the corresponding button. (Default)",
		           "2" : "2: LED indicates the status of the corresponding button, with inverted indication",
		           "3" : "3: LED indicates the status of corresponding paddle (in pair mode)",
		           "4" : "4: LED indicates the status of the corresponding paddle (in pair mode), with inverted indication",
		           "5" : "5: LED indicates the status of the built-in relay",
		           "6" : "6: LED indicates the status of the built-in relay, with inverted indication",
		           "7" : "7: LED show a 5 seconds indication when the corresponding button is pressed"]],

        [id: 10, size: 1, type: "enum", defaultValue: "1", required: false, readonly: false,
         name: "Relay mode",
         description : "This parameter configures which of the buttons that shall control the built-in relay, or if the relay only will be activated for one second, each time button #1 is used.",
		 options: ["0" : "0: Relay is disabled",
		           "1" : "1: Relay is controlled by button #1 or by upper paddle (Default)",
		           "1" : "2 Relay is controlled by button #2 or by upper paddle",
		           "1" : "3 Relay is controlled by button #3 or by middle paddle",
		           "1" : "4 Relay is controlled by button #4 or by middle paddle",
		           "1" : "5 Relay is controlled by button #5 or by lower paddle",
		           "1" : "6 Relay is controlled by button #6 or by lower paddle",
		           "1" : "5 Relay is activated for one second and is controlled by button #1 or by upper paddle"]],




/*
        [id:  1, size: 1, type: "number", range: "1..98", defaultValue: 1, required: false, readonly: false,
         name: "Minimum Brightness Level",
         description: "Set automatically during the calibration process, but can be changed afterwards.\n" +
         "Values: 1-98 = Brightness level (%)"],
        [id:  2, size: 1, type: "number", range: "2..99", defaultValue: 99, required: false, readonly: false,
         name: "Maximum Brightness Level",
         description: "Set automatically during the calibration process, but can be changed afterwards.\n" +
         "Values: 2-99 = Brightness level (%)"],
*/
    ]
}

/**
 *  getAssocGroupsMd()
 *
 *  Returns association groups metadata. Used by sync(), updateSyncPending(), and generatePrefsAssocGroups().
 *
 *  Reference: http://products.z-wavealliance.org/products/1729/assoc
 **/
private getAssocGroupsMd() {
    return [
        [id:  1, maxNodes: 1, name: "Lifeline",
         description : "Reports device state. Main Z-Wave controller should be added to this group."],

		[id:  2, maxNodes: 5, name: "Basic On/Off (B1)",
         description : "Send Basic Report (On/Off) when button #1 is used."],
        [id:  3, maxNodes: 5, name: "Binary Switch Set On/Off (B1)",
         description : "Sends Basic Set (On/Off) when button #1 is used."],
        [id:  4, maxNodes: 5, name: "Binary Switch Set On/Off (B1)",
         description : "Binary Switch Set (On/Off) when button #1 is used."],
        [id:  5, maxNodes: 5, name: "Binary Toggle (B1)",
         description : "Send Binary Toggle Switch Set when button #1 is used."],
        [id:  6, maxNodes: 5, name: "Multilevel Start Stop (B1)",
         description : "Sends Multilevel Switch Set / Multilevel Switch Start Level Change / Multilevel Switch Stop Level Change when button #1 is used."],

		[id:  7, maxNodes: 5, name: "Basic On/Off (B2)",
         description : "Send Basic Report (On/Off) when button #2 is used."],
        [id:  8, maxNodes: 5, name: "Binary Switch Set On/Off (B2)",
         description : "Sends Basic Set (On/Off) when button #2 is used."],
        [id:  9, maxNodes: 5, name: "Binary Switch Set On/Off (B2)",
         description : "Binary Switch Set (On/Off) when button #2 is used."],
        [id: 10, maxNodes: 5, name: "Binary Toggle (B2)",
         description : "Send Binary Toggle Switch Set when button #2 is used."],
        [id: 11, maxNodes: 5, name: "Multilevel Start Stop (B2)",
         description : "Sends Multilevel Switch Set / Multilevel Switch Start Level Change / Multilevel Switch Stop Level Change when button #2 is used."],

		[id: 12, maxNodes: 5, name: "Basic On/Off (B3)",
         description : "Send Basic Report (On/Off) when button #3 is used."],
        [id: 13, maxNodes: 5, name: "Binary Switch Set On/Off (B3)",
         description : "Sends Basic Set (On/Off) when button #3 is used."],
        [id: 14, maxNodes: 5, name: "Binary Switch Set On/Off (B3)",
         description : "Binary Switch Set (On/Off) when button #3 is used."],
        [id: 15, maxNodes: 5, name: "Binary Toggle (B3)",
         description : "Send Binary Toggle Switch Set when button #3 is used."],
        [id: 16, maxNodes: 5, name: "Multilevel Start Stop (B3)",
         description : "Sends Multilevel Switch Set / Multilevel Switch Start Level Change / Multilevel Switch Stop Level Change when button #3 is used."],

		[id: 17, maxNodes: 5, name: "Basic On/Off (B4)",
         description : "Send Basic Report (On/Off) when button #4 is used."],
        [id: 18, maxNodes: 5, name: "Binary Switch Set On/Off (B4)",
         description : "Sends Basic Set (On/Off) when button #4 is used."],
        [id: 19, maxNodes: 5, name: "Binary Switch Set On/Off (B4)",
         description : "Binary Switch Set (On/Off) when button #4 is used."],
        [id: 20, maxNodes: 5, name: "Binary Toggle (B4)",
         description : "Send Binary Toggle Switch Set when button #4 is used."],
        [id: 21, maxNodes: 5, name: "Multilevel Start Stop (B4)",
         description : "Sends Multilevel Switch Set / Multilevel Switch Start Level Change / Multilevel Switch Stop Level Change when button #4 is used."],

		[id: 22, maxNodes: 5, name: "Basic On/Off (B5)",
         description : "Send Basic Report (On/Off) when button #5 is used."],
        [id: 23, maxNodes: 5, name: "Binary Switch Set On/Off (B5)",
         description : "Sends Basic Set (On/Off) when button #5 is used."],
        [id: 24, maxNodes: 5, name: "Binary Switch Set On/Off (B5)",
         description : "Binary Switch Set (On/Off) when button #5 is used."],
        [id: 25, maxNodes: 5, name: "Binary Toggle (B5)",
         description : "Send Binary Toggle Switch Set when button #5 is used."],
        [id: 26, maxNodes: 5, name: "Multilevel Start Stop (B5)",
         description : "Sends Multilevel Switch Set / Multilevel Switch Start Level Change / Multilevel Switch Stop Level Change when button #5 is used."],

		[id: 27, maxNodes: 5, name: "Basic On/Off (B6)",
         description : "Send Basic Report (On/Off) when button #6 is used."],
        [id: 28, maxNodes: 5, name: "Binary Switch Set On/Off (B6)",
         description : "Sends Basic Set (On/Off) when button #6 is used."],
        [id: 29, maxNodes: 5, name: "Binary Switch Set On/Off (B6)",
         description : "Binary Switch Set (On/Off) when button #6 is used."],
        [id: 30, maxNodes: 5, name: "Binary Toggle (B6)",
         description : "Send Binary Toggle Switch Set when button #6 is used."],
        [id: 31, maxNodes: 5, name: "Multilevel Start Stop (B6)",
         description : "Sends Multilevel Switch Set / Multilevel Switch Start Level Change / Multilevel Switch Stop Level Change when button #6 is used."],
		 
	]
}
