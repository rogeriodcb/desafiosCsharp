using System;

namespace TinovaChallenge
{
	internal class Vote
	{
		private float totalDeEleitores;
		private float votosValidos;
		private float votosBrancos;
		private float votosNulos;

		public Vote(float te, float vv, float vb, float vn)
		{
			totalDeEleitores = te;
			votosValidos = vv;
			votosBrancos = vb;
			votosNulos = vn;

		}

		public float porcentagemVotosValidos()
		{
			return (votosValidos / totalDeEleitores) * 100;
		}

		public float porcentagemVotosBrancos()
		{
			return (votosBrancos / totalDeEleitores) * 100;
		}
		public float porcentagemVotosNulos()
		{
			return (votosNulos / totalDeEleitores) * 100;
		}
	}
}

