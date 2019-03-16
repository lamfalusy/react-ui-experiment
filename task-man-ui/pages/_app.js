import React from 'react';
import App, { Container } from 'next/app';
import Meta from '../components/Meta';
import NavBar from '../components/NavBar';

class MyApp extends App {

	render () {
		const { Component, pageProps } = this.props;

		return (
			<Container>
				<Meta/>
				<NavBar/>

				<Component {...pageProps} />
			</Container>
		);
	}
}

export default MyApp;