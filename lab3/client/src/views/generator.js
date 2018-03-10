import Generator from '../models/generator';

export default function (store) {
	return class GeneratorComponent extends window.HTMLElement {
		constructor () {
			super();
			this.store = store;

			// TODO: render generator initial view
	
			// TODO: subscribe to store on change event
			this.onStateChange = this.handleStateChange.bind(this);

			// TODO: add click event

		}

		handleStateChange(newState)
		{
			//this.innerHTML = this.init()
			const gen = new Generator(newState.generators[this.dataset.id]);

			this.innerHTML = `<h3><b>${gen.name}</b></h3>
			<p>${gen.description}</p>
			<button id="but">5 Skulls ${gen.generate}</button>
			<p><h5>5/60 ${gen.baseCost}</h5></p>`
			console.log('GeneratorComponentt#stateChange', this, newState);
		}

		connectedCallback()
		{

			//this.innerHTML = this.init();
			console.log('GeneratorComponent#onConnectedCallBack');
			this.store.subscribe(this.onStageChange);
		}

		disconnectedCallback(){
			console.log('GeneratorComponent#onDisconnectedCallBack');
			this.store.unsubscribe(this.onStageChange);
		}
/*
		init()
		{
			const id = this.dataset.id; 

			switch(id)
			{
				case '1':
					this.innerHTML = `
					<h3><b>Organs</b></h3> 
					<p>Their tiny Organs, the lowest of the low. Will only generate 10 Skulls per minute.</p>
					<button id="but">10 Skulls</button>
					<p><h5>5/60</h5></p>				
					`; break;

				case '2':

					this.innerHTML = `
					<h3><b>Corpses</b></h3> 
					<p>Their putrid Corpses will generate 500 Skulls per minute.</p>
					<button id="but">500 Skulls</button>
					<p><h5>25/60</h5></p>
					`;break;

				case '3':
					this.innerHTML = `
					<h3><b>Skeletons</b></h3> 
					<p>Their dry Skeletons will generate the most resource at 1000 Skulls per minute.</p>
					<button id="but">1000 Skulls</button>
					<p><h5>55/60</h5></p>
					`; break;
			}
		}*/
	
	};
}
