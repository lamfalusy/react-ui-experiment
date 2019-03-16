import React, {Component} from 'react';

class NavBar extends Component {
	render() {
		return (
			<nav className="navbar navbar-inverse">
				<div className="container">
					<div className="navbar-header">
						<a className="navbar-brand" href="/">Task Manager</a>
					</div>
					<div id="navbar" className="collapse navbar-collapse">
						<ul className="nav navbar-nav">
							<li><a href="/assignee-create">Create Assignee</a></li>
						</ul>
					</div>
				</div>
			</nav>
		);
	}
}

export default NavBar;