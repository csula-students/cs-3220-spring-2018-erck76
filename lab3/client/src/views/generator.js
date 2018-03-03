export default function (store) {
	return class GeneratorComponent extends window.HTMLElement {
		constructor () {
			super();
			this.store = store;

			// TODO: render generator initial view
			this.init();

			// TODO: subscribe to store on change event
			this.onStateChange = this.handleStateChange.bind(this);
			

			// TODO: add click event
			document.querySelector("#Organs").addEventListener('click',()=>{
				this.store.dispatch({
					type: 'BUY_GENERATOR',
					payload : "Organs",

				});
			});

			document.querySelector("#Skeletons").addEventListener('click',()=>{
				this.store.dispatch({
					type: 'BUY_GENERATOR',
					payload : "Skeletons",

				});
			});

			document.querySelector("#Skulls").addEventListener('click',()=>{
				this.store.dispatch({
					type: 'BUY_GENERATOR',
					payload : "Skulls",

				});
			});

		}

		handleStageChange(newState)
		{
		   console.log('GeneratorComponent#StateChange',this,newState);
			this.store.subscribe(newState);
		}

		connectedCallback()
		{
		   console.log('GeneratorComponent#onConnectedCallBack');
		   this.store.subscribe(this.onStageChange);	
		}
		disconnectedCallback()
		{
			console.log('GeneratorComponent#onDisconnectedCallBack');
			this.store.unsubscribe(this.onStageChange);
		}

		init()
		{
			const id = this.dataset.id;
			this

			switch(id)
			{
				case '10':
				this.innerHTML = `
				<div class="card">
				<div class="container">
					<game-generator data-id='10' data-payload="Organs"></game-generator>
				</div>
			</div>`; break;

				case '500':
				this.innerHTML = `
				<h3><b>Corpses</b></h3> 
							<p>Their putrid Corpses will generate 500 Skulls per minute.</p>
							<button id="but">500 Skulls</button>
							<p><h5>25/60</h5></p>`; break;
				case '1000':
				this.innerHTML = `
				<h3><b>Skeletons</b></h3> 
							<p>Their dry Skeletons will generate the most resource at 1000 Skulls per minute.</p>
							<button id="but">1000 Skulls</button>
							<p><h5>55/60</h5></p>`; break;

				

			}
		
		}
	}		
};
