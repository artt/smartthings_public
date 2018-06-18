preferences {
}

metadata {
	definition (name: "Test Switch", namespace: "fishix10", author: "fishix10") {
		capability "Actuator"
		capability "Switch"
		capability "Momentary"
		capability "Sensor"
        
		attribute "about", "string"
        attribute "xxx", "string"
	}

	// simulator metadata
	simulator {
	}
 
	tiles(scale: 2) {
    	standardTile(name: "toggle", type: "device.switch", width: 4, height: 4, canChangeIcon: true, canChangeBackground: true) {
			state "off", label: 'Off', action: "on", icon: "st.switches.switch.off", backgroundColor: "#ffffff", nextState: "on"
			state "on", label: 'On', action: "off", icon: "st.switches.switch.on", backgroundColor: "#00a0dc", nextState: "off"
		}
		standardTile(name: "switch_on", type: "device.xxx", width: 2, height: 2) {
			state "normal", label: 'On', action: "on"
		}
		standardTile(name: "switch_off", type: "device.xxx", width: 2, height: 2) {
			state "normal", label: 'Off', action: "off"
		}
        valueTile(name: "value_tile", type: "device.switch", width: 2, height: 2) {
        	state "val", label: '${name}', defaultState: true
        }
		main "toggle"
		details(["toggle", "switch_on", "switch_off", "value_tile"])
	}
    
}

def on() {
	log.debug "---ON COMMAND---"
    sendEvent(name: "switch", value: "on", isStateChange: true, display: true)
}

def off() {
	log.debug "---OFF COMMAND---"
    sendEvent(name: "switch", value: "off", isStateChange: true, display: true)
}

def push() {}