preferences {    
	section("Internal Access"){
		input "id_pw", "text", title: "ID & PW for RM Plugin or RM Bridge(Optional)", required: false
		input "internal_ip", "text", title: "IP for RM Plugin or RM Bridge or HA(Required for all)", required: true
		input "internal_port", "text", title: "Port(Required for all)", required: true
		input "internal_on_path", "text", title: "On Path(Required for all)", required: true
        input "internal_off_path", "text", title: "Off Path", required: false
	}
}

metadata {
	definition (name: "Test Switch", namespace: "fishix10", author: "fishix10") {
		capability "Actuator"
		capability "Switch"
		capability "Momentary"
		capability "Sensor"
        
		attribute "about", "string"

		main "switch_on"
		details(["switch_on, switch_off"])
	}

	// simulator metadata
	simulator {
	}

	tiles(scale: 2) {
		standardTile(name: "switch_on", type: "generic", width: 2, height: 2) {
			action: switch.on
		}
		standardTile(name: "switch_off", type: "generic", width: 2, height: 2) {
			action: switch.off
		}
	}